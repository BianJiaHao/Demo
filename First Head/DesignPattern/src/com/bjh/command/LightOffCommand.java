package com.bjh.command;

public class LightOffCommand implements Command{

    LightReceiver lightReceiver;

    public LightOffCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void ececute() {
         lightReceiver.off();
    }

    @Override
    public void undo() {
        lightReceiver.on();
    }
}
