package com.spring.regular.designPattern.策略模式;

/**
 * @author wanli zhou
 * @created 2018-03-19 9:39 AM.
 */
public class FirstSkillBehavior implements SkillBehavior {
    @Override
    public void performSkill() {
        System.out.println("使用 E 穿刺， 控制敌人2秒");
    }
}
