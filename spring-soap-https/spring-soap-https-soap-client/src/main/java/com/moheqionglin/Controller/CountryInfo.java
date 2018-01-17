package com.moheqionglin.Controller;

import com.moheqionglin.cxfEndpoint.CountryResponse;

/**
 * @author wanli zhou
 * @created 2018-01-16 2:22 PM.
 */
public class CountryInfo {

    private String name ;
    private String capital;
    private String currency;
    private int population;

    public CountryInfo(){}
    public CountryInfo(CountryResponse cr){
        this.name = cr.getName();
        this.capital = cr.getCapital();
        this.currency = cr.getCurrency();
        this.population = cr.getPopulation();
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
