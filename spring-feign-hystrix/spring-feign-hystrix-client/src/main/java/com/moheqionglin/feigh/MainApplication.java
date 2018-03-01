package com.moheqionglin.feigh;

import com.netflix.config.ConfigurationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableFeignClients
public class MainApplication {
	Logger log = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@PostConstruct
	void disableHystrixTimeout () {
//		Method[] methods = SyncBlockClient.class.getMethods();
//
//		String methodName;
//		for(int i = 0; i < methods.length; i++) {
//			methodName = methods[i].getName();
//			System.out.println(methodName);
//			if(methodName.contains("getPerson1")){
//				log.info("==||| =={}== ||| ==", methodName);
//				ConfigurationManager.getConfigInstance().setProperty(String.format("hystrix.command.%s.execution.isolation.thread.timeoutInMilliseconds", methodName),
//						8000);
//			}
//		}

		ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.enabled", false);
		ConfigurationManager.getConfigInstance().setProperty("hystrix.command.SyncBlockClient#getPerson(Integer).execution.isolation.thread.timeoutInMilliseconds", 10000);
//		ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.timeout.enabled", false);
//		ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.thread.interruptOnTimeout", false);
		//ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", 6000);
		//ConfigurationManager.getConfigInstance().setProperty("ribbon.ReadTimeout", 6000);

	}
}
