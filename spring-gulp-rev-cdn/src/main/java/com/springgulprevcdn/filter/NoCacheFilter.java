package com.springgulprevcdn.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Seriously, when will IE stop making me do this
 */
@Order(110)
@WebFilter(urlPatterns = {"/p/*", "/resources/*", "*.jsp"})
public class NoCacheFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		res.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		res.addHeader("Pragma", "No-cache");
		res.addHeader("Expires", "0");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}


	@Override
	public void destroy() {
	}

}
