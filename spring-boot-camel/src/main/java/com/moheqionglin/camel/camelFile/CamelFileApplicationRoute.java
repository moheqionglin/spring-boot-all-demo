package com.moheqionglin.camel.camelFile;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:12 PM.
 */
@Component
public class CamelFileApplicationRoute extends RouteBuilder{

    //http://blog.csdn.net/qq_21033663/article/details/52458305
    @Override
    public void configure() throws Exception {
        from("file://.camel-watch/camel-file/camel.file?moveFailed=.camel-error/")
                .log("====INDEX COMPANY FILE READ ${header.CamelFileNameOnly} ======")
                .split(body().tokenize("\n"))
                    .to("bean:camelFileBusinessLogic?method=doBusiness")
                .end();
    }
}
