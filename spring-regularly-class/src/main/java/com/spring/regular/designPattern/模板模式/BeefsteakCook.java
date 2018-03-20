package com.spring.regular.designPattern.模板模式;

/**
 * @author wanli zhou
 * @created 2018-03-13 1:41 PM.
 */
public class BeefsteakCook extends AbstractCookTemplate{
    @Override
    protected void prepareFood() {
        System.out.println("=> 准备牛肉，胡椒粉。 注意是西餐，不要给我油盐酱醋，用不上");
    }

    @Override
    protected void prepareTools() {
        System.out.println("=> 准备刀叉，盘子。 我可不会用筷子");
    }

    @Override
    protected boolean isChineseFood() {
        return false;
    }

    @Override
    protected void hook() {
        System.out.println("=> 西餐结束，请你西微波炉");
    }
}
