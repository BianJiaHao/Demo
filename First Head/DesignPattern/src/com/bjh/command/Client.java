package com.bjh.command;

public class Client {
    public static void main(String[] args) {
        //使用命令模式，完成通过遥控器，对电灯的操作

        //创建电灯的对象（接受者）
        LightReceiver lightReceiver = new LightReceiver();

        //创建电视的对象（接受者）
        TVReceiver tvReceiver = new TVReceiver();

        //创建电灯相关的开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        //创建电视相关的开关命令
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);

        //创建一个遥控器
        Remotecontroller remotecontroller = new Remotecontroller();

        //给我们的遥控器设置命令，比如 no = 0 是电灯的开和关的操作
        remotecontroller.setCommand(0,lightOnCommand,lightOffCommand);
        remotecontroller.setCommand(1,tvOnCommand,tvOffCommand);

        System.out.println("-----按下灯开的按钮-----");
        remotecontroller.onButtonWasPushed(0);
        System.out.println("-----按下灯关的按钮-----");
        remotecontroller.offButtonWasPushed(0);
        System.out.println("-----撤销-----");
        remotecontroller.undoButtonWasPushed();

        System.out.println("-----按下电视开的按钮-----");
        remotecontroller.onButtonWasPushed(1);
        System.out.println("-----按下电视关的按钮-----");
        remotecontroller.offButtonWasPushed(1);
        System.out.println("-----撤销-----");
        remotecontroller.undoButtonWasPushed();





    }
}
