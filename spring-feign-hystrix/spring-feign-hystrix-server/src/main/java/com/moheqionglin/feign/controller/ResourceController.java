package com.moheqionglin.feign.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanli zhou
 * @created 2018-01-19 3:17 PM.
 */
@RestController
public class ResourceController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(path = "/syncBlock/{blockTime}")
    public Person syncBlock(@PathVariable("blockTime") Integer blockTime){
        log.info("====STARR=====");
        try {
            Thread.sleep(blockTime);
        } catch (InterruptedException e) {
            log.info("===EXCEPTION====");
            e.printStackTrace();
        }
        log.info("======END========");
        return new Person("ResourceController", "girl");
    }
}


