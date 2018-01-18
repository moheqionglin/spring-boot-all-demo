package com.moheqionglin.CountryEndpoint;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import java.lang.annotation.*;

/**
 * wzp 10/01/2018.
 */
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@ImportAutoConfiguration({CountryEndpointConfig.class})
public @interface EnableCountryEndpointApi {

}
