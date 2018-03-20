package com.spring.regular.designPattern.职责连模式;

/**
 * @author wanli zhou
 * @created 2018-03-19 3:01 PM.
 */

public class FilterChainProxy {

    private FilterChain filterChains;

    public FilterChain getFilterChains() {
        return filterChains;
    }

    public void setFilterChains(FilterChain filterChains) {
        this.filterChains = filterChains;
    }
}
