package com.spring.regular.designPattern.代理模式.JDKDynamicProxy;

/**
 * @author wanli zhou
 * @created 2018-03-14 1:23 PM.
 */
public class Person implements IPerson{

    @Override
    public void doSomething() {
        System.out.println("=> 做事情");
    }
}
