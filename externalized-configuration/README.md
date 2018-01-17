#README
https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html
Spring Boot uses a very particular PropertySource order that is designed to allow sensible overriding of values. Properties are considered in the following order:

- Devtools global settings properties on your home directory (~/.spring-boot-devtools.properties when devtools is active).
- @TestPropertySource annotations on your tests.
- @SpringBootTest#properties annotation attribute on your tests.
- Command line arguments.
- Properties from SPRING_APPLICATION_JSON (inline JSON embedded in an environment variable or system property)
- ServletConfig init parameters.
- ServletContext init parameters.
- JNDI attributes from java:comp/env.
- Java System properties (System.getProperties()).
- OS environment variables.
- A RandomValuePropertySource that only has properties in random.*.
- Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants)
- Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants)
- Application properties outside of your packaged jar (application.properties and YAML variants).
- Application properties packaged inside your jar (application.properties and YAML variants).
- @PropertySource annotations on your @Configuration classes.
- Default properties (specified using SpringApplication.setDefaultProperties).