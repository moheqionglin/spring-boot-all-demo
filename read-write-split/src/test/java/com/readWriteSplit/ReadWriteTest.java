package com.readWriteSplit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wanli zhou
 * @created 2018-03-13 10:57 PM.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadWriteTest {

    @Autowired
    private QueryService queryService;
    @Test
    public void query1Test(){
        queryService.query1();
    }

    @Test
    public void query2Test(){
        queryService.query2();
    }

    @Test
    public void query3Test(){
        queryService.query3();
    }
}
