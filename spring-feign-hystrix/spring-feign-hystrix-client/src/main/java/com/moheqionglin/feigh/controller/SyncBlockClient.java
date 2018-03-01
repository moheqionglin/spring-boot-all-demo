package com.moheqionglin.feigh.controller;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wanli zhou
 * @created 2018-01-19 3:22 PM.
 */
//@FeignClient(name = "NAME", url = "${server.resource.path}", configuration = SyncBlockClientConfig.class)
@FeignClient(name = "NAME", url = "${server.resource.path}")
public interface SyncBlockClient {

    @RequestMapping(method = RequestMethod.GET,
            value = "/syncBlock/{blockTime}",
            consumes = "application/json")
    public Person getPerson(@PathVariable("blockTime") Integer blockTime);

    @RequestMapping(method = RequestMethod.GET,
            value = "/syncBlock/specialConfig/{blockTime}",
            consumes = "application/json")
    public Person getPerson1(@PathVariable("blockTime") Integer blockTime);




}
