package com.spring.regular;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wanli zhou
 * @created 2018-03-09 8:25 PM.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringContextUtilTest {

    @Autowired
    private SpringContextUtil springContextUtil;
    @Test
    public void springContextTest(){
        System.out.println(this.springContextUtil.getApplicationContext());
    }

    @Test
    public void springEventTest(){
        ApplicationContext context = springContextUtil.getApplicationContext();
        MoHeEvent moHeEvent = new MoHeEvent("source", "周万里", "工大");
        context.publishEvent(moHeEvent);
    }

}
