package com.spring.regular.designPattern.职责连模式;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author wanli zhou
 * @created 2018-03-19 3:12 PM.
 */
public class PreAuthenticatedProcessingFilter implements Filter{
    Logger log = LoggerFactory.getLogger(this.getClass());


    @Override
    public void doFilter(HttpRequest var1, HttpResponse var2, FilterChain var3) throws IOException, ServletException {
        log.info("=> start PreAuthenticatedProcessingFilter ");
        var2.setResponseContext(var2.getResponseContext() + " [start PreAuthenticatedProcessingFilter] ");
        var3.doFilter(var1, var2);
        log.info("=> end PreAuthenticatedProcessingFilter ");
        var2.setResponseContext(var2.getResponseContext() + " [end PreAuthenticatedProcessingFilter] ");
    }
}
