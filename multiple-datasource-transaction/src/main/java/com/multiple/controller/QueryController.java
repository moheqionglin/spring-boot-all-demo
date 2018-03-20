package com.multiple.controller;

import com.multiple.entity.ds1.ChemicalStructure;
import com.multiple.entity.ds2.ChemicalStructureDs2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanli zhou
 * @created 2018-03-12 4:06 PM.
 */
@RestController
@RequestMapping("/query/" )
public class QueryController {

    @Autowired
    private QueryDs1Service service1 ;
    @Autowired
    private QueryDs2Service service2;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("ds1/{id}")
    public ChemicalStructure getChemicalStructure(@PathVariable("id") Integer id){
        log.info("==ds1==>{}", id);
        return service1.getChemicalStructure(id);
    }

    @GetMapping("ds2/{id}")
    public ChemicalStructureDs2 getChemicalStructure2(@PathVariable("id") Integer id){
        log.info("==ds2==>{}", id);
        return service2.getChemicalStructure(id);
    }





}
