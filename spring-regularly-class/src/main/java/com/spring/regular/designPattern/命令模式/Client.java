package com.spring.regular.designPattern.命令模式;

/**
 * @author wanli zhou
 * @created 2018-03-13 9:48 AM.
 */
public class Client {
    ICommand[] command ;

    ICommand currentCommand;

    public Client(){
        command = new ICommand[2];
    }

    public void setCommand(int slot, ICommand command){
        this.command[slot] = command;
    }

    public void triggerButton(int slot){
        command[slot].execute();
        currentCommand = command[slot];
    }

    public void cancelButton(){
        if(currentCommand != null){
            currentCommand.undo();
        }

    }
}
