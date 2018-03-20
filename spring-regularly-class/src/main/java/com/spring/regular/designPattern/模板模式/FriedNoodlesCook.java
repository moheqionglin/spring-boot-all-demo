package com.spring.regular.designPattern.模板模式;

/**
 * @author wanli zhou
 * @created 2018-03-13 1:39 PM.
 */
/**
 * 炒面
 * */
public class FriedNoodlesCook extends AbstractCookTemplate{
    @Override
    protected void prepareFood() {
        System.out.println("=> 准备面条，西红柿，鸡蛋，葱姜蒜，柴米油盐");
    }

    @Override
    protected void prepareTools() {
        System.out.println("=> 准备筷子，盘子，碗，炒菜锅");
    }

    @Override
    protected boolean isChineseFood() {
        return true;
    }

    @Override
    protected void hook() {
        System.out.println("=> 中餐比较油烟，饭后清洗油压机。");
    }
}
