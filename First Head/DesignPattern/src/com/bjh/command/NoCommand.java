package com.bjh.command;

/**
 * 没有任何命令，即空执行，用于初始化每个按钮，当调用空命令是，对象什么都不做即可
 * 其实，这也是一种设计模式，可以省掉对空命令的判断
 */
public class NoCommand implements Command{
    @Override
    public void ececute() {

    }

    @Override
    public void undo() {

    }
}
