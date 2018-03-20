package com.transaction.spring.business;

import com.transaction.spring.domain.Province;
import com.transaction.spring.message.ProvinceInfo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author wanli zhou
 * @created 2018-03-08 3:03 PM.
 */
@Component
public class ProvinceService {
    @PersistenceContext
    private EntityManager em;


    public ProvinceInfo getProvince(Integer id){
        return new ProvinceInfo(em.find(Province.class, id));
    }

//    @Transactional(propagation = Propagation.REQUIRED)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.NEVER)
//    @Transactional(propagation = Propagation.MANDATORY)
//    @Transactional(propagation = Propagation.NESTED)
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveProvinceForPropagation(ProvinceInfo provinceInfo){
        Province province = new Province();
        province.setName(provinceInfo.getName());
        province.setCode(provinceInfo.getCode());
        em.persist(province);
    }

    /**
     *
     * 事务的隔离级别：
     * 多个事务操作同一数据，按照 READ , UPDATE, INSERT 的顺序不同会产生如下几种错误
     *    ==> Isolation.DEFAULT 数据库默认隔离级别
     *    Isolation.READ_UNCOMMITTED --> 引起 脏读
     *   1、脏读:  事务1 先UPDATE 未提交事务， 事务2 READ 能读取未提交完成的数据  --> 解决方法：加上写锁，写入的时候不允许读取。 Isolation.READ_COMMITTED
     *   2、不可重复读： 事务1线READ， 事务2UPDATE， 事务1未结束又读取，两次结果不一样。---> 解决方法：对同一条数据加上读锁，读取的时候，不允许修改。 Isolation.REPEATABLE_READ
     *   3、幻读： 事务1先读，未结束，事务2insert， 因为无法对未知的东西枷锁，所以 ---> 解决方法 Isolation.SERIALIZABLE
     *
     * */
//    @Transactional(isolation = Isolation.DEFAULT)
//    @Transactional(isolation = Isolation.READ_COMMITTED)
//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
//    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void saveProvinceForIsolationTest(ProvinceInfo provinceInfo){

    }


    @Transactional(timeout = 100)
    public void saveProvinceForTimeoutTest(ProvinceInfo provinceInfo){

    }

    @Transactional(readOnly = true)
    public void saveProvinceForReadOnlyTest(ProvinceInfo provinceInfo){

    }

}
