package com.moheqionglin;

/**
 * @author wanli zhou
 * @created 2018-01-16 4:56 PM.
 */

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.net.URL;
import java.security.KeyStore;

/**
 * @author wanli zhou
 * @created 2018-01-16 4:38 PM.
 */
@Component
public class SSLConfig {

    private String password = "123456";
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public void configureSSLOnTheClient(Object c) {

        Client client = ClientProxy.getClient(c);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

        ByteArrayInputStream in = new ByteArrayInputStream(initEmailHeaderImage());
        try {
            TLSClientParameters tlsParams = new TLSClientParameters();
            tlsParams.setDisableCNCheck(true);

            //KeyStore用于存放证书，创建对象时 指定交换数字证书的加密标准
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(in, password.toCharArray());

            //TrustManager决定是否信任对方的证书
            TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustFactory.init(keyStore);
            TrustManager[] tm = trustFactory.getTrustManagers();
            tlsParams.setTrustManagers(tm);
            //KeyManager选择证书证明自己的身份
//            keyStore.load(in, password.toCharArray());
//            KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//            keyFactory.init(keyStore, password.toCharArray());
//            KeyManager[] km = keyFactory.getKeyManagers();
//            tlsParams.setKeyManagers(km);
            httpConduit.setTlsClientParameters(tlsParams);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private byte[] initEmailHeaderImage() {
        try {
            final String imageResource = "/keystore.p12";
            final URL url = getClass().getResource(imageResource);
            InputStream is = null;
            if(null == url){
                log.info("can not get the ssl key by the url : {}", imageResource);
                throw new RuntimeException("can not get the ssl key by the url " + imageResource);
            }

            if (url.toString().startsWith("jar:")) {
                is = getClass().getResourceAsStream(imageResource);
            } else {
                try {
                    is = new FileInputStream(new File(url.getFile()));
                } catch (FileNotFoundException e) {
                    log.error("can not find image {}", e.getMessage());
                }
            }
            if(null != is){
                try {
                    int length = is.available();
                    byte buf[] = new byte[length];
                    is.read(buf);
                    log.info("********>>Get ssl key : {}<<********", buf);
                    return buf;
                } catch (IOException e) {
                    log.error("convert email header image file to byte error, {}", e.getMessage());
                    throw new RuntimeException("convert email header image file to byte error");
                }
            }
        } catch (Exception ex) {
            log.error("get image fail! {}", ex.getMessage());
            throw new RuntimeException("get image fail!");
        }
        return null;
    }
}