package com.readWriteSplit;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author wanli zhou
 * @created 2018-03-13 9:25 PM.
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDatasource();
    }
}
