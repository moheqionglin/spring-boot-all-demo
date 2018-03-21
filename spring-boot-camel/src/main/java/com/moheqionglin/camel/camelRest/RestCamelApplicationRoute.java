package com.moheqionglin.camel.camelRest;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:12 PM.
 */
@Component
public class RestCamelApplicationRoute extends RouteBuilder{

    //http://blog.csdn.net/qq_21033663/article/details/52458305
    @Override
    public void configure() throws Exception {
        from("direct:rest1:param1")
                .routeId("direct1:rest1:param1")
                .to("bean:camelRestBusinessLogic?method=getPerson")
        ;
    }
}
