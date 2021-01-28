package com.bjh.jmh.juc;
/**
 *同步方法和非同步方法是否可以同时执行
 */
public class Test_02 {

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + "m1 is started");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1 is end");
    }

    public void m2(){
        System.out.println(Thread.currentThread().getName() + "m2 is started");
    }

    public static void main(String[] args) {
        Test_02 t = new Test_02();
        new Thread(()->t.m1(),"t1").start();
        new Thread(()->t.m2(),"t2").start();
    }
}
