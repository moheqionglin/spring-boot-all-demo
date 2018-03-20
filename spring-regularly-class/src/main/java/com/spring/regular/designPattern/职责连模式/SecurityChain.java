package com.spring.regular.designPattern.职责连模式;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author wanli zhou
 * @created 2018-03-20 11:09 AM.
 */
public class SecurityChain {


    public static void main(String[] args) throws IOException, ServletException {
        SecurityChain securityChain = new SecurityChain();

        DefaultSecurityFilterChain filterChain = securityChain.initFilterChainProxy();
        HttpRequest request = new HttpRequest();
        HttpResponse response = new HttpResponse();

        filterChain.doFilter(request, response);

        System.out.println(response.getResponseContext());

    }


    public DefaultSecurityFilterChain initFilterChainProxy(){
        DefaultSecurityFilterChain fc = new DefaultSecurityFilterChain();
        fc.getFilters().add(new SecurityContextPersistenceFilter());
        fc.getFilters().add(new LogoutFilter());
        fc.getFilters().add(new PreAuthenticatedProcessingFilter());
        fc.getFilters().add(new AuthenticatedProcessingFilter());
        fc.getFilters().add(new ConcurrentSessionFilter());
        fc.getFilters().add(new AnonymousAuthenticateFilter());
        fc.getFilters().add(new SessionManagerFilter());
        fc.getFilters().add(new SwitchUserFilter());

        return fc;
    }
}
