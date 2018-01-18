package com.moheqionglin.cxfEndpoint.endpoint;

import com.moheqionglin.cxfEndpoint.message.CountryByNameRequest;
import com.moheqionglin.cxfEndpoint.message.CountryResponse;
import com.moheqionglin.cxfEndpoint.repository.Country;
import com.moheqionglin.cxfEndpoint.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author wanli zhou
 * @created 2018-01-16 2:22 PM.
 */
@WebService(serviceName = "CountryEndpointService", //服务名
        targetNamespace = "http://endpoint.cxfEndpoint.moheqionglin.com",//报名倒叙，并且和接口定义保持一致
        endpointInterface = "com.moheqionglin.cxfEndpoint.endpoint.CountryEndpoint")
@Component("countryEndpoint")
public class CountryEndpointImpl implements CountryEndpoint{

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected CountryRepository countryRepository;
    public CountryEndpointImpl(){}

    public CountryResponse getCountryByName(CountryByNameRequest req) {
        log.info("Get Country By Name Request: {}", req.getName());
        Country c = countryRepository.findCountry(req.getName());
        if(c == null){
            throw new RuntimeException("Not Found by Name : " + req.getName());
        }
        return new CountryResponse(c);
    }
}
