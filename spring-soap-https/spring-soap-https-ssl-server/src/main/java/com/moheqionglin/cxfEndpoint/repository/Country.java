package com.moheqionglin.cxfEndpoint.repository;

/**
 * @author wanli zhou
 * @created 2018-01-16 2:16 PM.
 */
public class Country {
    private String name ;
    private String capital;
    private String currency;
    private int population;

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
