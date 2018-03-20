package com.spring.regular.designPattern.策略模式;

import org.springframework.core.annotation.Order;

/**
 * @author wanli zhou
 * @created 2018-03-19 9:41 AM.
 */
public class SecondSkillBehavior implements SkillBehavior{
    @Order
    public void performSkill() {
        System.out.println("使用第二技能 R， 埋沙。");
    }
}
