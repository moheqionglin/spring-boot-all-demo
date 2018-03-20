package com.spring.regular.designPattern.策略模式;

/**
 * @author wanli zhou
 * @created 2018-03-18 7:24 PM.
 */
public abstract class DotaHero {
    String name = null;
    SkillBehavior skill = null;


    public void doSkill(){
        if(skill != null){
            skill.performSkill();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillBehavior getSkill() {
        return skill;
    }

    public void setSkill(SkillBehavior skill) {
        this.skill = skill;
    }
}
