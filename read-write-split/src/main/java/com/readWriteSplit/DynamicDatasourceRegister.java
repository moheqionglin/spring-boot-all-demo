package com.readWriteSplit;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanli zhou
 * @created 2018-03-13 8:44 PM.
 */
@Component
public class DynamicDatasourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware{

    private static String DATASOURCE_DEFAULT = "org.apache.tomcat.jdbc.pool.DataSource";
    DataSource defaultDs;
    private PropertyValues propertyValues;

    private Map<String, DataSource> customDataSource = new HashMap<>();

    @Override
    public void setEnvironment(Environment environment) {
        defaultDatasource(environment);
        customDatasource(environment);
    }

    private void customDatasource(Environment environment) {
        customDataSource(environment);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Map<Object, Object> targetDataSource = new HashMap<Object, Object>();
        targetDataSource.put("datasource", defaultDs);
        DynamicDataSourceContextHolder.getDatasourceIds().add("datasource");

        targetDataSource.putAll(customDataSource);
        for(String key : customDataSource.keySet()){
            DynamicDataSourceContextHolder.getDatasourceIds().add(key);
        }
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue("defaultTargetDataSource", defaultDs);;
        propertyValues.addPropertyValue("targetDataSources", targetDataSource);
        beanDefinitionRegistry.registerBeanDefinition("datasource", beanDefinition);
    }

    private void dataBinder(DataSource datasource, Environment environment){
        RelaxedDataBinder relaxedDataBinder = new RelaxedDataBinder(datasource);
        relaxedDataBinder.setConversionService(new DefaultConversionService());
        relaxedDataBinder.setIgnoreNestedProperties(false);
        relaxedDataBinder.setIgnoreInvalidFields(false);
        relaxedDataBinder.setIgnoreUnknownFields(true);
        if(propertyValues == null){
            Map<String, Object> dsMap = new RelaxedPropertyResolver(environment, "spring.datasource").getSubProperties(".");
            Map<String, Object> values = new HashMap<>(dsMap);
            values.remove("type");
            values.remove("driver-class-name");
            values.remove("url");
            values.remove("username");
            values.remove("password");
            propertyValues = new MutablePropertyValues(values);

        }

    }

    private void defaultDatasource(Environment environment){
        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
        Map<String, Object> dsMap = new HashMap<>();
        dsMap.put("type", relaxedPropertyResolver.getProperty("type"));
        dsMap.put("driver-class-name", relaxedPropertyResolver.getProperty("driver-class-name"));
        dsMap.put("url", relaxedPropertyResolver.getProperty("url"));
        dsMap.put("username", relaxedPropertyResolver.getProperty("username"));
        dsMap.put("password", relaxedPropertyResolver.getProperty("password"));
        defaultDs = buildDataSource(dsMap);
    }
    private void defaultDataBinder(DataSource datasource, Environment environment){
        dataBinder(datasource, environment);
    }

    private DataSource buildDataSource(Map<String, Object> dsmap){
        Object type = dsmap.get("type");
        if(type == null){
            type = DATASOURCE_DEFAULT;
        }
        try {
            Class<? extends DataSource> dsClazz = (Class<? extends DataSource>) Class.forName((String) type);
            DataSourceBuilder factory = DataSourceBuilder.create()
                    .driverClassName((String) dsmap.get("driver-class-name"))
                    .url((String) dsmap.get("url"))
                    .username((String) dsmap.get("username"))
                    .password((String) dsmap.get("password"));
            return (DataSource) factory.build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void customDataSource(Environment environment){
        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "custom.datasource.");
        String dsNames = relaxedPropertyResolver.getProperty("names");
        for(String dsName : dsNames.split(",")){
            Map<String, Object> subProperties = relaxedPropertyResolver.getSubProperties(dsName + ".");
            DataSource ds = buildDataSource(subProperties);
            dataBinder(ds, environment);
            customDataSource.put(dsName, ds);
        }

    }
}
