package com.readWriteSplit;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-03-13 9:23 PM.
 */
@Component
public class DynamicDataSourceContextHolder {
    private static List<String> datasourceIds  = new ArrayList<>();

    private static final ThreadLocal<String> local = new ThreadLocal<>();
    public static String getDatasource() {
        return local.get();
    }

    public static boolean containsDataSource(String dataSource){
        return datasourceIds.contains(dataSource);
    }
    public static void setDatasource(String datasource) {
       local.set(datasource);
    }

    public static List<String> getDatasourceIds() {
        return datasourceIds;
    }
}
