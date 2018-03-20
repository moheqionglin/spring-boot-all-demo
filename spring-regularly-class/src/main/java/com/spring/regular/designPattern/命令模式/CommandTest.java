package com.spring.regular.designPattern.命令模式;

/**
 * @author wanli zhou
 * @created 2018-03-13 10:17 AM.
 */
public class CommandTest {
    public static void main(String[] args) {
        Client client = new Client();
        Light light = new Light();
        client.setCommand(0, new LightOnCommand(light));
        client.setCommand(1, new LightOffCommand(light));


        client.triggerButton(0);

        client.cancelButton();
    }
}
