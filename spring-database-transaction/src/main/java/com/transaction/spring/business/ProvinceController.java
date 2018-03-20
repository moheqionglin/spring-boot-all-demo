package com.transaction.spring.business;

import com.transaction.spring.message.ProvinceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanli zhou
 * @created 2018-03-08 2:25 PM.
 */
@Controller
@RequestMapping(path = "/province/", consumes = "application/json", produces = "application/json")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/{id}")
    public ProvinceInfo getProvince(@PathVariable("id") Integer id){
        return provinceService.getProvince(id);
    }



}
