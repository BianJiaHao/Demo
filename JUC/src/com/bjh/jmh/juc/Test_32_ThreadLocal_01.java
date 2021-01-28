package com.bjh.jmh.juc;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程局部变量
 */
public class Test_32_ThreadLocal_01 {

    volatile static Person  p = new Person();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "lisa";
        }).start();
    }



    static class Person{
        String name = "Obito";
    }
}
