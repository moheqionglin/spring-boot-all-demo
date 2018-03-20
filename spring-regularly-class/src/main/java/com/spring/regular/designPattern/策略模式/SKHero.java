package com.spring.regular.designPattern.策略模式;

/**
 * @author wanli zhou
 * @created 2018-03-18 7:27 PM.
 */
public class SKHero extends DotaHero {
    public SKHero(String name, SkillBehavior skill) {
        this.name = name;
        this.skill = skill;
    }

}
