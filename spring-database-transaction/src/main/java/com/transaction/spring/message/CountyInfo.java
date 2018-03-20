package com.transaction.spring.message;

import com.transaction.spring.domain.County;

/**
 * @author wanli zhou
 * @created 2018-03-08 2:21 PM.
 */
public class CountyInfo{
    private Integer id;
    private String name;
    private String code;

    public CountyInfo(County c){
        this.id = c.getId();
        this.name = c.getName();
        this.code = c.getCode();
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
        return "CountyInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}