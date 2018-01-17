package com.moheqionglin;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * @author wanli zhou
 * @created 2018-01-16 10:56 PM.
 */
public class SslSocketServer {


    public static void main(String[] args) {
        SslSocketServer ssl = new SslSocketServer();
        try {
            ssl.conn();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public void conn() throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {
        System.out.println("等待客户端连接...");
        final String imageResource = "/keystore.p12";
        final URL url = SslSocketServer.class.getResource(imageResource);
        InputStream stream = getClass().getResourceAsStream(imageResource);
        char[] password = "123456".toCharArray();

        //KeyStore用于存放证书，创建对象时 指定交换数字证书的加密标准
        KeyStore keyStore = KeyStore.getInstance("JKS"); //KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(stream, password);
        stream.close();

        //KeyManager选择证书证明自己的身份
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, password);
        KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();

        //TrustManager决定是否信任对方的证书
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

        SSLContext context = SSLContext.getInstance("SSL");
        context.init(keyManagers, trustManagers, null);
        SSLServerSocketFactory factory = context.getServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(3344);
        SSLSocket socket = (SSLSocket) serverSocket.accept();

        System.out.println("有客户端连接");
        System.out.println("向客户端输出信息");
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("hello world\r\n");
        writer.write("\r\n");
        writer.flush();
        System.out.println("输出结束");
        socket.close();
        serverSocket.close();
    }
}
