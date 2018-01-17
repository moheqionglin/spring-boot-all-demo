package com.moheqionglin.cxfEndpoint.message;

import com.moheqionglin.cxfEndpoint.repository.Country;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author wanli zhou
 * @created 2018-01-16 2:22 PM.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "message.cxfEndpoint.moheqionglin.com")
public class CountryResponse {

    private String name ;
    private String capital;
    private String currency;
    private int population;

    public CountryResponse (){}
    public CountryResponse(Country c){
        this.name = c.getName();
        this.capital = c.getCapital();
        this.currency = c.getCurrency();
        this.population = c.getPopulation();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
