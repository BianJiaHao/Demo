package com.bjh.jmh.juc;

import java.util.concurrent.TimeUnit;

/**
 * reentrantlock用于替代synchronized
 * 本例中由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 这里是复习synchronized最原始的语义
 */
public class Test_12_ReentrantLock_01 {

    synchronized public void m1(){
        for(int i=0;i<10;i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if(i == 2)
            m2();
        }
    }

    synchronized public void m2(){
        System.out.println("m2 start");
    }

    public static void main(String[] args) {
        Test_12_ReentrantLock_01 t = new Test_12_ReentrantLock_01();
        new Thread(()->t.m1()).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //new Thread(()->t.m2()).start();
    }
}
