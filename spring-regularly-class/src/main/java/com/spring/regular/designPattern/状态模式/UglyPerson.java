package com.spring.regular.designPattern.状态模式;

/**
 * @author wanli zhou
 * @created 2018-03-19 11:06 AM.
 */
public class UglyPerson {

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
                System.out.println("起床");
                break;
            case 12:
                System.out.println("午饭");
                break;
            case 18:
                System.out.println("下班");
                break;
            case 20:
                System.out.println("休息");
                break;
            default:
                System.out.println("上班/学习");
                break;
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
