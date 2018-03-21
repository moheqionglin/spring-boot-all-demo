package com.moheqionglin.camel.camelActivemq;

import com.moheqionglin.camel.camelActivemq.message.Person;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestOperationParamDefinition;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:05 PM.
 */
@Component
public class CamelActivemqRestCamelRoute extends RouteBuilder{
    ////http://blog.csdn.net/qq_21033663/article/details/52458305
    @Override
    public void configure() throws Exception {
        final RestOperationParamDefinition AUTH_PARAM = new RestOperationParamDefinition().name("X-Auth-Token")
                .type(RestParamType.header)
                .dataType("string").description("Auth Token for active user");

        rest("/activemq/{param1}")
                .get()
                    .type(String.class).outType(Person.class)
                    .description("activemq camel 集成接口")
                    .param(AUTH_PARAM)
                    .responseMessage().code(404).message("资源找不到的提示").endResponseMessage()
                    .responseMessage().code(400).message("客户端错误请求的提示").endResponseMessage()
                    .responseMessage().code(201).message("成功添加").endResponseMessage()
                    .responseMessage().code(200).message("操作成功").endResponseMessage()
                    .to("direct:activemq:param1");

    }
}
