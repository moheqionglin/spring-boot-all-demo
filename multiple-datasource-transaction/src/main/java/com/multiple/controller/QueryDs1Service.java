package com.multiple.controller;

import com.multiple.entity.ds1.ChemicalStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author wanli zhou
 * @created 2018-03-12 4:06 PM.
 */
@Service
public class QueryDs1Service {

    @PersistenceContext
    private EntityManager em;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public ChemicalStructure getChemicalStructure(Integer id){
        ChemicalStructure cs = em.createQuery("select cs FROM ChemicalStructure cs where cs.id = :id", ChemicalStructure.class)
                .setParameter("id", id).getSingleResult();
        log.info("==>{}", cs);
        return cs;
    }






}
