package com.moheqionglin.cxfEndpoint.endpoint;

import com.moheqionglin.cxfEndpoint.message.CountryByNameRequest;
import com.moheqionglin.cxfEndpoint.message.CountryResponse;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author wanli zhou
 * @created 2018-01-16 2:19 PM.
 */
// 命名空间,一般是接口的包名倒序
@WebService(targetNamespace = "http://endpoint.cxfEndpoint.moheqionglin.com")
public interface CountryEndpoint {
    @WebMethod
    public CountryResponse getCountryByName(CountryByNameRequest req);
}
