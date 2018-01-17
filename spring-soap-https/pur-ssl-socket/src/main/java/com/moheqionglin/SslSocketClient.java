package com.moheqionglin;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * @author wanli zhou
 * @created 2018-01-16 11:01 PM.
 */
public class SslSocketClient {

    public static void main(String[] args) {
        SslSocketClient ss = new SslSocketClient();
        try {
            ss.conn();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public void conn() throws CertificateException, NoSuchAlgorithmException, IOException, KeyStoreException, KeyManagementException {
        System.out.println("准备连接服务端");
        final String imageResource = "/keystore.p12";
        final URL url = SslSocketServer.class.getResource(imageResource);
        InputStream stream = getClass().getResourceAsStream(imageResource);
        char[] password = "123456".toCharArray();

        //指定交换数字证书的加密标准
        KeyStore keyStore = KeyStore.getInstance("JKS");//KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(stream, password);
        stream.close();

        //TrustManager决定是否信任对方的证书
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null, trustManagers, null);
        SSLSocketFactory factory = context.getSocketFactory();
        SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 3344);

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
        while ((str = reader.readLine()) != null) {
            if (str.equals(""))
                break;
            System.out.println(str);
        }
        socket.close();
    }
}
