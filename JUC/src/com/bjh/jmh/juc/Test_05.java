package com.bjh.jmh.juc;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
 * 也就是说synchronized获得的锁是可重入的
 * 这里是继承中有可能发生的情形，子类调用父类的同步方法
 */
public class Test_05 {

    static class Parent{
        public synchronized void m(){
            System.out.println("m started");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("m end");
        }
    }

    static class Child extends Parent{
        public synchronized void m(){
            System.out.println("child m started");

            super.m();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("child m end");

        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.m();
    }
}
