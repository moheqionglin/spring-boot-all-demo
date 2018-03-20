package com.readWriteSplit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-13 9:36 PM.
 */
@Aspect
@Order(-1)
@Component
public class DataSourceAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Before(value = "@annotation(targetDataSource)")
    public void datasource(JoinPoint joinpoint, TargetDataSource targetDataSource){
        String dsId = targetDataSource.name();
        if(!DynamicDataSourceContextHolder.containsDataSource(dsId)){
            log.error("===>");
        } else {
            log.info("++++>");
            DynamicDataSourceContextHolder.setDatasource(dsId);
        }
    }
}
