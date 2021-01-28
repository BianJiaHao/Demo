package com.bjh.jmh.juc;

import java.util.concurrent.Semaphore;

public class Test_21_Semaphore {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(2,true); //允许一个线程同时执行

        new Thread(()->{
            try {
                s.acquire();
                System.out.println("T1 is running");
                Thread.sleep(200);
                System.out.println("T1 is ended");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();
                System.out.println("T2 is running");
                Thread.sleep(200);
                System.out.println("T2 is ended");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
