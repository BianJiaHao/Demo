package com.bjh.jmh.juc;

import java.util.concurrent.TimeUnit;

/**
 * 程序在执行过程中，如果出现异常，默认情况锁会被释放
 * 所以，在并发处理的过程中，有异常要多加小心，不然可能会发生不一致的情况。
 * 比如，在一个web app处理过程中，多个servlet线程共同访问同一个资源，这时如果异常处理不合适，
 * 在第一个线程中抛出异常，其他线程就会进入同步代码区，有可能会访问到异常产生时的数据。
 * 因此要非常小心的处理同步业务逻辑中的异常
 */
public class Test_06 {

    int count = 0;

    public synchronized void m(){
        System.out.println(Thread.currentThread().getName() + "started");
        while (true){

            System.out.println(Thread.currentThread().getName() + "count = " + " " +count);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count ++;

            if( count == 10 ){
                count = 10 / 0;
            }
        }
    }

    public static void main(String[] args) {
        Test_06 t = new Test_06();
        new Thread(()->t.m(),"t1").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->t.m(),"t2").start();


    }
}
