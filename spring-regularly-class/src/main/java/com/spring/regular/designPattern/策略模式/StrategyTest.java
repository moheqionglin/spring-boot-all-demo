package com.spring.regular.designPattern.策略模式;

/**
 * @author wanli zhou
 * @created 2018-03-19 10:07 AM.
 */
public class StrategyTest {

    /**
     *
     *  http://blog.csdn.net/zhangliangzi/article/details/52161211
     *
     *  策略模式：  在开发中，有很多种选择，每一种选择都要做一定的处理。那么可以把这些选择的处理，抽象一个
     *  接口，然后每种选择都封装一个具体的策略类。 每种策略都可以动态的互换。  每种策略在client创建创建的时候
     *  就选定，比如
     *
     *  策略模式仅仅封装算法，提供新的算法插入到已有系统中
     *  策略模式的重心不是如何实现算法，而是如何组织、调用这些算法，从而让程序结构更灵活，具有更好的维护性和扩展性。
     *
     * **/


    /**
     *
     * 和状态模式的区别
     *   策略模式： 更强调调用方，非常清楚每种策略的具体内部算法，在对象初始化的时候，根据实际情况，主动选择某种策略去执行相关逻辑
     *   状态模式： 更强调，在状态变换的时候，不同算法之间的切换， 对象初始化的时候不关心具体的算法。
     *  https://www.cnblogs.com/kubixuesheng/p/5180509.html
     *   =========
     *   *如果 某各类中某个对象有多种状态， 不同状态下行为存在差异， 而且这些状态 可以相互转换使用 状态模式
     *   * 如果系统某各类的某个行为，有多重实现方式， 而这些实现方式可以相互替换， 用 侧路模式
     *
     *
     *   和 简单工厂模式对比：
     *
     *    简单工厂模式： 强调 封装对象创建的逻辑。 让对象的创建和具体业务代码解耦。
     *    策略模式：     强调 对行为的封装， 让行为的具体实现，跟业务代码解耦， 只需要在对象创建的时候选择具体的 策略。
     *
     *
     * **/
    public static void main(String[] args) {

        SKHero sk = new SKHero("沙王", new FirstSkillBehavior());
        sk.doSkill();

        sk.setSkill(new SecondSkillBehavior());
        sk.doSkill();
    }
}
