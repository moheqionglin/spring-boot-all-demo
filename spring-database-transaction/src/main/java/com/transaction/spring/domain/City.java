package com.transaction.spring.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-03-08 2:20 PM.
 */
@Entity
@Table(name = "city")
public class City{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "city")
    List<County> counties;


    public List<County> getCounties() {
        return counties;
    }

    public void setCounties(List<County> counties) {
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}