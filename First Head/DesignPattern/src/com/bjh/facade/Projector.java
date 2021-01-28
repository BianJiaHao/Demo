package com.bjh.facade;

public class Projector {
    private Projector(){

    }

    private static Projector instance = new Projector();

    private static Projector getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("Projector on");
    }

    public void focus(){
        System.out.println("Projector is focusing");
    }

    public void off(){
        System.out.println("Projector off");
    }
}
