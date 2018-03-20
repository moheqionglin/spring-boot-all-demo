package com.transaction.spring.message;

import com.transaction.spring.domain.City;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanli zhou
 * @created 2018-03-08 2:20 PM.
 */
public class CityInfo{

    private Integer id;
    private String name;
    private String code;
    private ProvinceInfo province;
    List<CountyInfo> counties;

    public CityInfo() {
    }

    public CityInfo(City c) {
        this.id = c.getId();
        this.name = c.getName();
        this.code = c.getCode();
        this.counties = c.getCounties().stream().map(CountyInfo::new).collect(Collectors.toList());
    }

    public List<CountyInfo> getCounties() {
        return counties;
    }

    public void setCounties(List<CountyInfo> counties) {
        this.counties = counties;
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

    public ProvinceInfo getProvince() {
        return province;
    }

    public void setProvince(ProvinceInfo province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "CityInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", province=" + province +
                ", counties=" + counties +
                '}';
    }
}