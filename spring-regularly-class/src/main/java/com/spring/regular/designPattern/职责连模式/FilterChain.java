package com.spring.regular.designPattern.职责连模式;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author wanli zhou
 * @created 2018-03-19 3:01 PM.
 */
public interface FilterChain {

    boolean matches(HttpRequest request);

    void doFilter(HttpRequest var1, HttpResponse var2) throws IOException, ServletException;
}
