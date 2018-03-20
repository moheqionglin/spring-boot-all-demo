package com.spring.regular.designPattern.策略模式;

/**
 * @author wanli zhou
 * @created 2018-03-19 10:06 AM.
 */
public class LastSkillBehavior implements SkillBehavior{
    @Override
    public void performSkill() {
        System.out.println("大招： C， 地震");
    }
}
