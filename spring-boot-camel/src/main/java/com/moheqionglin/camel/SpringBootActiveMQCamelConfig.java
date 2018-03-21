package com.moheqionglin.camel;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.camel.component.ActiveMQConfiguration;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wanli zhou
 * @created 2017-04-13 7:41 PM.
 */
@Configuration
public class SpringBootActiveMQCamelConfig {

    @Bean
    public ActiveMQComponent activemq(PooledConnectionFactory connectionFactory){
        final ActiveMQConfiguration config = new ActiveMQConfiguration();
        config.setConnectionFactory(connectionFactory);
        config.setTrustAllPackages(true);
        ActiveMQComponent activeMQComponent = new ActiveMQComponent(config);
        activeMQComponent.setTrustAllPackages(true);
        return activeMQComponent;
    }
}
