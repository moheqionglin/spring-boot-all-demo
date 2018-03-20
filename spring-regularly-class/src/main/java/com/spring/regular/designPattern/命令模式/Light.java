package com.spring.regular.designPattern.命令模式;

/**
 * @author wanli zhou
 * @created 2018-03-13 9:44 AM.
 */
public class Light {
    public void on(){
        System.out.println("[命令的执行者] 打开灯的开关");
    }
    public void off(){
        System.out.println("[命令的执行者] 关系灯的开关");
    }
}
