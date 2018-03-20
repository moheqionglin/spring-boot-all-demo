package com.spring.regular.designPattern.状态模式.state;


/**
 * @author wanli zhou
 * @created 2018-03-19 11:14 AM.
 */
public class WorkOrStudyState implements IState {
    @Override
    public void doSth(Person person) {
        System.out.println("工作/学习");
        person.setState(new GetUpState());
    }
}
