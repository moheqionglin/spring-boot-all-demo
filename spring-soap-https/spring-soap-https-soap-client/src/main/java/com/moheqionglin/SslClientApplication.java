package com.moheqionglin;

import com.moheqionglin.CountryEndpoint.EnableCountryEndpointApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableCountryEndpointApi
public class SslClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(SslClientApplication.class, args);
	}

}
