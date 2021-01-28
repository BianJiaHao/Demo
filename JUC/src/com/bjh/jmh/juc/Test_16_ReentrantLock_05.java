package com.bjh.jmh.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 *ReentrantLock还可以指定为公平锁
 */
public class Test_16_ReentrantLock_05 {
    private static ReentrantLock lock = new ReentrantLock(true);

    public void m(){
        for(int i=0; i<100; i++) {
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally{
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Test_16_ReentrantLock_05 t = new Test_16_ReentrantLock_05();
        new Thread(()->t.m(),"t1").start();
        new Thread(()->t.m(),"t2").start();
    }
}
