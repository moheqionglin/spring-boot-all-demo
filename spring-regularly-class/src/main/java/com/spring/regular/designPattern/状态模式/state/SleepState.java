package com.spring.regular.designPattern.状态模式.state;


/**
 * @author wanli zhou
 * @created 2018-03-19 11:14 AM.
 */
public class SleepState implements IState {
    @Override
    public void doSth(Person person) {
        if(person.getHours() == 20){
            System.out.println("睡觉");
        }else{
            person.setState(new WorkOrStudyState());
            person.doSth();
        }

    }
}
