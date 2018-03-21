package com.moheqionglin.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author nick
 */
@Component
public class RestRouteConfiguration extends RouteBuilder{

	@Value("${camel.servlet.path}")
	private String camelUrl;
	@Value("${server.port}")
	private Integer nonSecurePort;
	@Value("${server.contextPath}")
	private String contextPath;
	
	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet")
				.dataFormatProperty("prettyPrint", "true")
				.contextPath(contextPath + camelUrl)
				//host/port don't affect services at all, looking to fill in 
				//issues with documentation generation.
				.port(nonSecurePort)
				.host("localhost")
				.bindingMode(RestBindingMode.json)
				.apiContextPath("/api-doc")
					.apiProperty("api.title", "LabNetwork Pricing API")
					.apiProperty("api.version", "1.0");
	}
}
