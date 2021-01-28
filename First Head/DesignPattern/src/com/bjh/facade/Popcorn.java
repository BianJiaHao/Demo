package com.bjh.facade;

public class Popcorn {

    private Popcorn(){

    }

    private static Popcorn instance = new Popcorn();

    private static Popcorn getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("popcorn on");
    }

    public void pop(){
        System.out.println("create popcorn");
    }

    public void off(){
        System.out.println("popcorn off");
    }
}
