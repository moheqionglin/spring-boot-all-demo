package com.spring.regular.designPattern.职责连模式;

/**
 * @author wanli zhou
 * @created 2018-03-19 2:59 PM.
 */
public class HttpRequest {
    private String path;

    private String requestContext;

    public String getRequestContext() {
        return requestContext;
    }

    public void setRequestContext(String requestContext) {
        this.requestContext = requestContext;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
