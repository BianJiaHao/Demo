package com.bjh.command;
//创建命令接口
public interface Command {
    //执行某个操作
    public void ececute();
    //撤销某个操作
    public void undo();
}
