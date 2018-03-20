package com.spring.regular.designPattern.职责连模式;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanli zhou
 * @created 2018-03-20 11:12 AM.
 */
public class DefaultSecurityFilterChain implements FilterChain{

    private List<Filter> filters = new ArrayList<>();
    private int currentPosition = 0;
    @Override
    public boolean matches(HttpRequest request) {
        return false;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }


    public void doFilter(HttpRequest request, HttpResponse response) throws IOException, ServletException {
        if (this.currentPosition < this.getFilters().size()) {
            Filter nextFilter = this.getFilters().get( this.currentPosition++);
            nextFilter.doFilter(request, response, this);
        }

    }
}
