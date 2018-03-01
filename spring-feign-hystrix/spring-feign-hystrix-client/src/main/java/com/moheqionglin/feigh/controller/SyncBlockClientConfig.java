package com.moheqionglin.feigh.controller;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wanli zhou
 * @created 2018-01-19 3:24 PM.
 */
@Configuration
public class SyncBlockClientConfig {

    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 5000);
    }

}
