package com.moheqionglin.camel.camelRest;

import com.moheqionglin.camel.camelRest.message.Person;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestOperationParamDefinition;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:05 PM.
 */
@Component
public class RestCamelRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        final RestOperationParamDefinition AUTH_PARAM = new RestOperationParamDefinition().name("X-Auth-Token")
                .type(RestParamType.header)
                .dataType("string").description("Auth Token for active user");

        rest("/rest1/{param1}")
                .get()
                    .type(String.class).outType(Person.class)
                    .description("rest1 是一个测试接口")
                    .param(AUTH_PARAM)
                    .responseMessage().code(404).message("资源找不到的提示").endResponseMessage()
                    .responseMessage().code(400).message("客户端错误请求的提示").endResponseMessage()
                    .responseMessage().code(201).message("成功添加").endResponseMessage()
                    .responseMessage().code(200).message("操作成功").endResponseMessage()
                    .to("direct:rest1:param1");

    }
}
