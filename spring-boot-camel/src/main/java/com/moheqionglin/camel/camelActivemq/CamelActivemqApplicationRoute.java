package com.moheqionglin.camel.camelActivemq;

import com.moheqionglin.camel.camelActivemq.message.Person;
import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:12 PM.
 */
@Component
public class CamelActivemqApplicationRoute extends RouteBuilder{

    //http://blog.csdn.net/qq_21033663/article/details/52458305
    @Override
    public void configure() throws Exception {
        from("direct:activemq:param1")
                .routeId("direct:activemq:param1")
                .to("bean:camelActivemqBusinessLogic?method=getPerson")
                .marshal( new JacksonDataFormat(Person.class))
                .to("activemq:activemq1:param1")
                .to("bean:camelActivemqBusinessLogic?method=getPerson")
                .marshal( new JacksonDataFormat(Person.class))
                .to(ExchangePattern.InOnly,"activemq:topic:activemq1:param1")
        ;

        from("activemq:activemq1:param1")
                .routeId("activemq:activemq1:param1")
                .unmarshal(new JacksonDataFormat(Person.class))
                .log(LoggingLevel.INFO, "=> ${body} queue 消费者1")
                .to("bean:camelActivemqBusinessLogic?method=doSomething")
                ;
        from("activemq:activemq1:param1")
                .routeId("activemq:activemq1:param12")
                .unmarshal(new JacksonDataFormat(Person.class))
                .log(LoggingLevel.INFO, "=> ${body} queue 消费者1")
                .to("bean:camelActivemqBusinessLogic?method=doSomething")
        ;
        from("activemq:topic:activemq1:param1")
                .routeId("topic:activemq1:param1:activemq1")
                .unmarshal(new JacksonDataFormat(Person.class))
                .log(LoggingLevel.INFO, "=> ${body} topic 消费者1")
                .to("bean:camelActivemqBusinessLogic?method=doSomething")
        ;
        from("activemq:topic:activemq1:param1")
                .routeId("topic:activemq1:param1:activemq2")
                .unmarshal(new JacksonDataFormat(Person.class))
                .log(LoggingLevel.INFO, "=> ${body} topic  消费者2")
                .to("bean:camelActivemqBusinessLogic?method=doSomething")
        ;
        from("activemq:topic:activemq1:param1")
                .routeId("topic:activemq1:param1:activemq3")
                .unmarshal(new JacksonDataFormat(Person.class))
                .log(LoggingLevel.INFO, "=> ${body} topic 消费者3")
                .to("bean:camelActivemqBusinessLogic?method=doSomething")
        ;
    }
}
