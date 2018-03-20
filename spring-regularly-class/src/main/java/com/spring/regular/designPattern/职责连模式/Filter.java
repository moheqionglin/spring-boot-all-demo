package com.spring.regular.designPattern.职责连模式;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author wanli zhou
 * @created 2018-03-19 3:02 PM.
 */
public interface Filter {

    void doFilter(HttpRequest var1, HttpResponse var2, FilterChain var3) throws IOException, ServletException;

}
