package com.moheqionglin.CountryEndpoint;

import com.moheqionglin.SSLConfig;
import com.moheqionglin.cxfEndpoint.CountryEndpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * wzp 10/01/2018.
 */
@Configuration
public class CountryEndpointConfig {
    @Value("${soap.https.endpoint}")
    private String address;

    @Autowired
    private SSLConfig sslConfig;

    @Bean("httpsCountryEndpoint")
    public CountryEndpoint getCountryEndpoint() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(CountryEndpoint.class);
        jaxWsProxyFactoryBean.setAddress(address + "CountryEndpoint");
        CountryEndpoint manager = (CountryEndpoint) jaxWsProxyFactoryBean.create();
        ClientProxy.getClient(manager);
        sslConfig.configureSSLOnTheClient(manager);
        return manager;
    }


}
