package com.bjh.facade;

public class TheaterLight {
    private TheaterLight(){

    }

    private static TheaterLight instance = new TheaterLight();

    private static TheaterLight getInstance(){
        return instance;
    }

    public void up(){
        System.out.println("TheaterLight up");
    }

    public void down(){
        System.out.println("TheaterLight down");
    }
}
