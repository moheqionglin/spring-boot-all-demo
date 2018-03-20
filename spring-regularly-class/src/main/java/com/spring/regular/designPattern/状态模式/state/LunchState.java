package com.spring.regular.designPattern.状态模式.state;


/**
 * @author wanli zhou
 * @created 2018-03-19 11:13 AM.
 */
public class LunchState implements IState{
    @Override
    public void doSth(Person person) {
        if(person.getHours() == 12){
            System.out.println("午饭");
        }else{
            person.setState(new WorkDownState());
            person.doSth();
        }

    }
}
