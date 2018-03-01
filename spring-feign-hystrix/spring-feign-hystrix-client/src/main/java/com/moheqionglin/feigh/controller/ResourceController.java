package com.moheqionglin.feigh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanli zhou
 * @created 2018-01-19 3:17 PM.
 */
@RestController
public class ResourceController {


    private final SyncBlockClient syncBlockClient;

    @Autowired
    public ResourceController(SyncBlockClient syncBlockClient){
        this.syncBlockClient = syncBlockClient;
    }
    @GetMapping(path = "/syncBlock/{blockTime}")
    public Person syncBlock(@PathVariable("blockTime") Integer blockTime){
        return syncBlockClient.getPerson(blockTime);
    }
    @GetMapping(path = "/syncBlock/specialConfig/{blockTime}")
    public Person syncBlock1(@PathVariable("blockTime") Integer blockTime){
        return syncBlockClient.getPerson(blockTime);
    }

}


