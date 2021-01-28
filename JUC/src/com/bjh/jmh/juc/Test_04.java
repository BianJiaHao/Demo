package com.bjh.jmh.juc;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
 * 也就是说synchronized获得的锁是可重入的
 */
public class Test_04 {

    public synchronized void m1(){
        System.out.println("m1 started");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        m2();

        System.out.println("m1 end");
    }

    public synchronized void m2(){
        System.out.println("m2 started");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("m2 end");
    }

    public static void main(String[] args) {
        Test_04 t = new Test_04();
        t.m1();
    }
}
