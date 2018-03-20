package com.spring.regular.designPattern.状态模式.state;


/**
 * @author wanli zhou
 * @created 2018-03-19 11:13 AM.
 */
public class GetUpState implements IState{

    public GetUpState(){

    }
    @Override
    public void doSth(Person person) {
        if(person.getHours() == 7){
            System.out.println("起床");
        }else{
            person.setState(new LunchState());
            person.doSth();
        }

    }
}
