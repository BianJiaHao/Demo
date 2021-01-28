package com.bjh.facade;

public class Stereo {
    private Stereo(){

    }

    private static Stereo instance = new Stereo();

    private static Stereo getInstance(){
        return instance;
    }

    public void up(){
        System.out.println("Stereo up");
    }

    public void down(){
        System.out.println("Stereo down");
    }
}
