package com.spring.regular.designPattern.状态模式.uglystate;

/**
 * @author wanli zhou
 * @created 2018-03-19 11:13 AM.
 */
public class LunchState implements IState{
    @Override
    public void doSth() {
        System.out.println("午饭");
    }
}
