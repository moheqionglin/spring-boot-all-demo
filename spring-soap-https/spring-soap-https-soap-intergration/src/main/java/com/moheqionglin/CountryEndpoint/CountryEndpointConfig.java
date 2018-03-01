package com.moheqionglin.CountryEndpoint;

import com.moheqionglin.SSLConfig;
import com.moheqionglin.security.CxfLoggingInInterceptor;
import com.moheqionglin.security.CxfLoggingOutInterceptor;
import com.moheqionglin.security.PasswordCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * wzp 10/01/2018.
 */
@Configuration
public class CountryEndpointConfig {
    @Value("${soap.https.endpoint}")
    private String address;
    @Value("${cxf.user}")
    private String user;
    @Autowired
    private SSLConfig sslConfig;

    @Autowired
    private PasswordCallback passwordCallback;

    @Autowired
    private CxfLoggingInInterceptor cxfLoggingInInterceptor;
    @Autowired
    private CxfLoggingOutInterceptor cxfLoggingOutInterceptor;

//    @Bean("httpsCountryEndpoint")
//    public CountryEndpoint getCountryEndpoint() {
//        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
//        jaxWsProxyFactoryBean.setServiceClass(CountryEndpoint.class);
//        jaxWsProxyFactoryBean.setAddress(address + "CountryEndpoint");
//        CountryEndpoint manager = (CountryEndpoint) jaxWsProxyFactoryBean.create();

        //security
//        Map<String, Object> outProps = Maps.newHashMap();
//        outProps.put(WSHandlerConstants.ACTION, "UsernameToken Timestamp"); //WSHandlerConstants.USERNAME_TOKEN
//        outProps.put(WSHandlerConstants.USER, user);
//        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
//        outProps.put(WSHandlerConstants.PW_CALLBACK_REF, passwordCallback);
//        WSS4JOutInterceptor wSS4JOutInterceptor = new WSS4JOutInterceptor(outProps);
//        Client client = ClientProxy.getClient(manager);
//        client.getOutInterceptors().add(wSS4JOutInterceptor);
//        client.getInInterceptors().add(cxfLoggingInInterceptor);
//        client.getOutInterceptors().add(cxfLoggingOutInterceptor);


//
//        sslConfig.configureSSLOnTheClient(manager);
//        return manager;
//    }

}
