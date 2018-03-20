package com.spring.regular.designPattern.状态模式.uglystate;

/**
 * @author wanli zhou
 * @created 2018-03-19 11:06 AM.
 */
public class UglyPerson {

    private IState state = null;
    private int hours = 0;
    /**
     * 缺点： 每次增加新的状态，都要修改doSth代码。 违背了 开放 关闭原则。 能不能保证 doSth不懂？
     * */
    public static void main(String[] args) {
        UglyPerson person = new UglyPerson();
        person.setHours(2);
        person.doSth();
    }


    public void doSth(){
        switch (hours){
            case 7:
                state = new GetUpState();
                break;
            case 12:
                state = new LunchState();
                break;
            case 18:
                state = new WorkDownState();
                break;
            case 20:
                state = new SleepState();
                break;
            default:
                state = new WorkOrStudyState();
                break;
        }
        state.doSth();
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
