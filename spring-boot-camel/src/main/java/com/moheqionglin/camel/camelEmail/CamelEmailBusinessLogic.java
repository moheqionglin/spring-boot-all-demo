package com.moheqionglin.camel.camelEmail;

import com.moheqionglin.camel.camelActivemq.message.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:13 PM.
 */
@Component
public class CamelEmailBusinessLogic {

    Logger log = LoggerFactory.getLogger(this.getClass());


    public Person doBusiness(String str){
        log.info("==> file : {}", str);
        Person p = new Person();
        p.setAddress("上海");
        p.setName(str);
        p.setSex("女");
        return p;
    }

}
