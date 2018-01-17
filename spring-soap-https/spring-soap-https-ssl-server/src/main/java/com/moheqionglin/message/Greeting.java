package com.moheqionglin.message;

/**
 * @author wanli zhou
 * @created 2018-01-16 10:55 AM.
 */

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}