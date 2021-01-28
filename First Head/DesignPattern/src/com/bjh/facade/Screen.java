package com.bjh.facade;

import java.util.Scanner;

public class Screen {
    private Screen(){

    }

    private static Screen instance = new Screen();

    private static Screen getInstance(){
        return instance;
    }

    public void up(){
        System.out.println("Screen up");
    }

    public void down(){
        System.out.println("Screen down");
    }
}
