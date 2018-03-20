package com.spring.regular.designPattern.策略模式;

/**
 * @author wanli zhou
 * @created 2018-03-19 10:05 AM.
 */
public class ThirdSkillBehavior implements SkillBehavior{
    @Override
    public void performSkill() {
        System.out.println("第三技能： r， 腐蚀毒");
    }
}
