package com.moheqionglin.camel.camelActivemq;

import com.moheqionglin.camel.camelActivemq.message.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:13 PM.
 */
@Component
public class CamelActivemqBusinessLogic {

    Logger log = LoggerFactory.getLogger(this.getClass());

    public Person doSomething(Person p){
        return p;
    }

    public Person getPerson(){
        Person p = new Person();
        p.setAddress("上海");
        p.setName("赵日天");
        p.setSex("女");
        return p;
    }

}
