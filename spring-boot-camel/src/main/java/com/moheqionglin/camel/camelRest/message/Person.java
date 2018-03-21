package com.moheqionglin.camel.camelRest.message;

import java.io.Serializable;

/**
 * @author wanli zhou
 * @created 2018-03-20 10:31 PM.
 */
public class Person implements Serializable{
    private String name;
    private String sex;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
