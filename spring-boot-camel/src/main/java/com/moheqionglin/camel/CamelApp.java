package com.moheqionglin.camel;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.swagger.servlet.RestSwaggerCorsFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:01 PM.
 */
@SpringBootApplication
public class CamelApp {

    @Value("${camel.servlet.path}")
    private String camelUrl;

    public static void main(String... args) {
        SpringApplication.run(CamelApp.class, args);
    }


    @Bean
    public ServletRegistrationBean camelServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), camelUrl + "*");
        registration.setName("CamelServlet");
        return registration;
    }
    @Bean
    public FilterRegistrationBean apiCorsFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean(new RestSwaggerCorsFilter());
        filter.addUrlPatterns(camelUrl + "api-doc/*");
        filter.setName("RestSwaggerCorsFilter");
        return filter;
    }
}

