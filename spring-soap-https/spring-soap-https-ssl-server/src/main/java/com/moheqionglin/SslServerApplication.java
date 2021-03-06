package com.moheqionglin;

import com.moheqionglin.cxfEndpoint.endpoint.CountryEndpoint;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Endpoint;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
public class SslServerApplication {
	//https://drissamri.be/blog/java/enable-https-in-spring-boot/
	//https://howtodoinjava.com/spring/spring-boot/spring-boot-ssl-https-example/
	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

	@Autowired
	private Bus bus;
	@Autowired
	private CountryEndpoint countryEndpoint;

	@Value("${ssl.soap.username}")
	private String userName;
	@Value("${ssl.soap:password}")
	private String password;

	@Value("${server.port}")
	private Integer sslPort;
	@Value("${server.nonssl.port}")
	private Integer nonSslPort;
	//http://cxf.apache.org/docs/ws-security.html
	//http://techtots.blogspot.jp/2016/07/enabling-ws-security-in-spring-boot.html
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, countryEndpoint);
		endpoint.publish("/CountryEndpoint");//接口发布在 /NetbarServices 目录下
		//Add WSS logic
//		Map<String, Object> inProps = new HashMap<>();
//		inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
//		inProps.put(WSHandlerConstants.USER, userName);
//		inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
//		inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, WSSecurityCallback.class.getName());
//
//		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
//		endpoint.getInInterceptors().add(wssIn);
		return endpoint;
	}

	@Bean public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new CXFServlet(), "/services/*");
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				securityConstraint.addCollection(collection);
				context.addConstraint(securityConstraint);
			}
		};

		tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
		return tomcat;
	}

	private Connector initiateHttpConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(nonSslPort);
		connector.setSecure(false);
		connector.setRedirectPort(sslPort);

		return connector;
	}
}
