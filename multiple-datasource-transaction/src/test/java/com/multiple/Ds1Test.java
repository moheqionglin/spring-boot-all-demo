package com.multiple;

import com.multiple.entity.ds1.ChemicalStructure;
import com.multiple.entity.ds2.ChemicalStructureDs2;
import com.multiple.entity.ds2.LNChemicalStructure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author wanli zhou
 * @created 2018-03-13 2:56 PM.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Ds1Test {

    @PersistenceContext
    private EntityManager em;
    @PersistenceContext(unitName = "secondDs")
    private EntityManager em2;

    @Test
    public void queryTest(){

        ChemicalStructure cs = em.createQuery("select cs FROM ChemicalStructure cs where cs.id = :id", ChemicalStructure.class)
                .setParameter("id", 268236).getSingleResult();
        System.out.println(cs);
    }

    @Test
    public void test(){
        System.out.println("d");
        System.out.println(em2.createNativeQuery("select id From chemical_structures where id = 14616").getSingleResult());
    }

    @Test
    @Transactional
    public void getChemicalStructure(){
        ChemicalStructureDs2 cs = em2.createQuery("select cs FROM ChemicalStructureDs2 cs where cs.id = :id", ChemicalStructureDs2.class)
                .setParameter("id", 14616).getSingleResult();
        System.out.println(cs);
    }

    @Test
    public void getChem(){
        System.out.println(em2.createQuery("SELECT c.id FROM LNChemicalStructure c ORDER BY c.updatedAt ASC", Integer.class)
                .setMaxResults(1)
                .setFirstResult(1)
                .getResultList());
    }
}
