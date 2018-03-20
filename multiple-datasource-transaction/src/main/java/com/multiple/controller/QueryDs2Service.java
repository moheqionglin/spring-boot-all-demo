package com.multiple.controller;

import com.multiple.entity.ds1.ChemicalStructure;
import com.multiple.entity.ds2.ChemicalStructureDs2;
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
public class QueryDs2Service {

    @PersistenceContext(unitName = "secondDs")
    private EntityManager em;
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Transactional
    public ChemicalStructureDs2 getChemicalStructure(Integer id){
        ChemicalStructureDs2 cs = em.createQuery("select cs FROM ChemicalStructureDs2 cs where cs.id = :id", ChemicalStructureDs2.class)
                .setParameter("id", id).getSingleResult();
        log.info("===> {}", cs);
        return cs;
    }
}
