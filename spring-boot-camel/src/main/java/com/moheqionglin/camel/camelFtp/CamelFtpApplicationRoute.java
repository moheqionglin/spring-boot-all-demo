package com.moheqionglin.camel.camelFtp;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-21 3:05 PM.
 */
@Profile("ftp")
@Component
public class CamelFtpApplicationRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        FtpConfiguration ftpConfig = new FtpConfiguration();
        from("ftp://" + ftpConfig.getUser() + "@" + ftpConfig.getHost() + ":" + ftpConfig.getPort() + "/"  + "?password=" + ftpConfig.getPassword() +"&passiveMode=true&delete=true&recursive=true&doneFileName=${file:name.noext}.mrk")
                .routeId("camel.ftp.route")
                .description("Ftp process")
                .to("bean:camelRestBusinessLogic?method=doSth");
    }
}
