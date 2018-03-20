package com.spring.regular;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wanli zhou
 * @created 2018-03-09 8:50 PM.
 */
@Component
public class MoHeListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof MoHeEvent){
            MoHeEvent event = (MoHeEvent) applicationEvent;
            System.out.println(event.getName() + "\t" + event.getSchool());
        }
    }
}
