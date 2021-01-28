package com.bjh.command;

public class Remotecontroller {

    //开按钮的命令数组
    Command[] onCommands;

    //关按钮的命令数组
    Command[] offCommands;

    //执行撤销操作
    Command undoCommand;

    //构造器，完成对按钮的初始化
    public Remotecontroller(){
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();

        }
    }

    //给我们的按钮设置你需要的命令
    public void setCommand(int no,Command onCommand,Command offCommand){
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    //按下开按钮
    public void onButtonWasPushed(int no){
        //找到你按下的开的按钮，并调用对应的方法
        onCommands[no].ececute();
        //记录这次的操作，用于撤销
        undoCommand = onCommands[no];
    }

    //按下关按钮
    public void offButtonWasPushed(int no){
        //找到你按下的关的按钮，并调用对应的方法
        offCommands[no].ececute();
        //记录这次的操作，用于撤销
        undoCommand = offCommands[no];
    }

    //按下撤销按钮
    public void undoButtonWasPushed(){
        undoCommand.undo();
    }
}
