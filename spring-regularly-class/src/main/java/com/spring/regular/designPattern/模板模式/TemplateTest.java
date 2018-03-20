package com.spring.regular.designPattern.模板模式;

/**
 * @author wanli zhou
 * @created 2018-03-13 1:44 PM.
 */
public class TemplateTest {
    public static void main(String[] args) {
        BeefsteakCook beefsteakCook = new BeefsteakCook();
        FriedNoodlesCook friedNoodlesCook = new FriedNoodlesCook();

        beefsteakCook.templateCookMethod();
        friedNoodlesCook.templateCookMethod();
    }
}
