package com.moheqionglin.cxfEndpoint.message;

/**
 * @author wanli zhou
 * @created 2018-01-16 2:22 PM.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "message.cxfEndpoint.moheqionglin.com")
public class CountryByNameRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
