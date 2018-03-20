package com.spring.regular.designPattern.命令模式;

/**
 * @author wanli zhou
 * @created 2018-03-13 9:43 AM.
 */
public class LightOnCommand implements ICommand{

    Light light ;
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
