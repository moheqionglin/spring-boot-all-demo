package com.transaction.spring.business;

import com.transaction.spring.domain.City;
import com.transaction.spring.domain.Province;
import com.transaction.spring.message.CityInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author wanli zhou
 * @created 2018-03-08 8:20 PM.
 */
@Service
public class CityService {


    @PersistenceContext
    private EntityManager em;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveProvinceForPropagation(CityInfo cityInfo){
        City city = new City();
        city.setCode(cityInfo.getCode());
        city.setName(cityInfo.getName());
        city.setProvince(em.find(Province.class, cityInfo.getProvince().getId()));
        em.persist(city);
    }
}
