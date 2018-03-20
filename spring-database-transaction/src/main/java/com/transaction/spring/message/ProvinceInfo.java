package com.transaction.spring.message;

import com.transaction.spring.domain.Province;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanli zhou
 * @created 2018-03-08 2:22 PM.
 */
public class ProvinceInfo {
    private Integer id;
    private String name;
    private String code;
    List<CityInfo> cities;

    public ProvinceInfo() {
    }

    public ProvinceInfo(Province p){
        this.id = p.getId();
        this.name = p.getName();
        this.code = p.getCode();
        this.cities = p.getCities().stream().map(CityInfo::new).collect(Collectors.toList());
    }

    public List<CityInfo> getCities() {
        return cities;
    }

    public void setCities(List<CityInfo> cities) {
        this.cities = cities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ProvinceInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cities=" + cities +
                '}';
    }
}
