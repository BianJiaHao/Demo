package com.bjh.facade;

public class DVDPlayer {

    //使用单例模式
    private DVDPlayer(){

    }

    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("DVD on");
    }

    public void play(){
        System.out.println("DVD is playing");
    }

    public void off(){
        System.out.println("DVD off");
    }
}
