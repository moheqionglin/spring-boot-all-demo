package com.moheqionglin.Controller;

import com.moheqionglin.cxfEndpoint.CountryByNameRequest;
import com.moheqionglin.cxfEndpoint.CountryEndpoint;
import com.moheqionglin.cxfEndpoint.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanli zhou
 * @created 2018-01-16 10:03 PM.
 */
@RestController
public class CountryController {

    @Autowired
    private CountryEndpoint countryEndpoint;

    @GetMapping(path = "/country/{name}")
    public CountryInfo getCountryInfo(@PathVariable("name") String name){
        CountryByNameRequest req = new CountryByNameRequest();
        req.setName(name);
        CountryResponse rsp = countryEndpoint.getCountryByName(req);
        return new CountryInfo(rsp);
    }
}

