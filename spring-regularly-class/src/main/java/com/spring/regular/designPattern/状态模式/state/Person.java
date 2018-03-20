package com.spring.regular.designPattern.状态模式.state;


/**
 * @author wanli zhou
 * @created 2018-03-19 11:06 AM.
 */
public class Person {

    private IState state = null;
    private int hours = 0;
    /**
     * 缺点： 每次增加新的状态，都要修改doSth代码。 违背了 开放 关闭原则。 能不能保证 doSth不懂？
     * */
    public static void main(String[] args) {
        Person person = new Person();
        person.setHours(7);
        person.doSth();

        person.setHours(11);
        person.doSth();

        person.setHours(12);
        person.doSth();

        person.setHours(18);
        person.doSth();

        person.setHours(20);
        person.doSth();

    }

    public Person(){
        this.state = new GetUpState();
    }

    public void doSth(){
        state.doSth(this);
    }

    public void setState(IState state) {
        this.state = state;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
