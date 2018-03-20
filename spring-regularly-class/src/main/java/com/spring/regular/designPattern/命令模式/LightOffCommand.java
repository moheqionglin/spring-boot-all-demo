package com.spring.regular.designPattern.命令模式;

/**
 * @author wanli zhou
 * @created 2018-03-13 9:43 AM.
 */
public class LightOffCommand implements ICommand{

    Light light ;
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
