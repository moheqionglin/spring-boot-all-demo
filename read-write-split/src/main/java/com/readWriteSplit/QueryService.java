package com.readWriteSplit;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author wanli zhou
 * @created 2018-03-13 11:02 PM.
 */
@Component
public class QueryService {

    @PersistenceContext(unitName = "firstDs")
    private EntityManager em;

    private final static String QUERY = "select count(1) from DATABASECHANGELOG limit 1";

    public void query1(){
        System.out.println(em.createNativeQuery(QUERY).getSingleResult());
        System.out.println(em.createQuery(" select cs from ChemicalStructure cs where cs.id = :id", ChemicalStructure.class)
                .setParameter("id", 12345).getResultList());
    }

    @TargetDataSource(name = "ds1")
    public void query2(){
        System.out.println(em.createNativeQuery(QUERY).getSingleResult());
    }
    @TargetDataSource(name = "ds2")
    public void query3(){
        System.out.println(em.createNativeQuery(QUERY).getSingleResult());
        System.out.println(em.createQuery("select u FROM User u where u.dingDingId =:dingDingId", User.class)
        .setParameter("dingDingId", "04182642161821818175").getSingleResult());
    }

}
