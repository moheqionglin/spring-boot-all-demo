package com.spring.regular;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-09 8:48 PM.
 */
@Component
public class MoHeEvent extends ApplicationEvent {

    private String name;
    private String school;

    public MoHeEvent(Object source, String name, String school) {
        super(source);
        this.name = name;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
