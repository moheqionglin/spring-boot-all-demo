package com.multiple.ds;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanli zhou
 * @created 2018-03-12 3:54 PM.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.multiple.entity.ds1",
        entityManagerFactoryRef = "firstEntityManagerFactory",
        transactionManagerRef="firstTransactionManager")
public class FirstDsConfig {
    @Value("${first.datasource.hibernate.dialect}")
    private String dialect ;
    /**
     * 数据源配置对象
     * Primary 表示默认的对象，Autowire可注入，不是默认的得明确名称注入
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties("first.datasource")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 数据源对象
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties("first.datasource")
    public DataSource firstDataSource() {
        return firstDataSourceProperties().initializeDataSourceBuilder().build();
    }

    /**
     * 实体管理对象
     * @param builder 由spring注入这个对象，首先根据type注入（多个就取声明@Primary的对象），否则根据name注入
     * @return
     */
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(firstDataSource())
                .packages(com.multiple.entity.ds1.ChemicalStructure.class)
                .persistenceUnit("firstDs")
                .properties(createEntityManagerProperties())
                .build();
    }

    /**
     * 事务管理对象
     * @return
     */
    @Bean(name = "firstTransactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    private Map<String, Object> createEntityManagerProperties(){
        System.out.println("=============================");
        System.out.println(dialect);
        System.out.println("=============================");
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.ejb.naming_strategy", org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl.class.getName());
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.jdbc.use_get_generated_keys", true);
        properties.put("hibernate.id.new_generator_mappings", true);
        properties.put("hibernate.generate_statistics", false);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.ddl-auto", false);
        properties.put("hibernate.naming.physical-strategy", org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl.class.getName());
        properties.put("hibernate.show_sql", true);
        return properties;
    }
}