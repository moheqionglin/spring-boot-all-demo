package com.spring.regular.designPattern.状态模式.state;


/**
 * @author wanli zhou
 * @created 2018-03-19 11:14 AM.
 */
public class WorkDownState implements IState {
    @Override
    public void doSth(Person person) {
        if(person.getHours() == 18){
            System.out.println("下班");
        } else {
            person.setState(new SleepState());
            person.doSth();
        }

    }
}
