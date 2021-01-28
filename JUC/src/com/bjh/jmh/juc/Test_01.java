package com.bjh.jmh.juc;

public class Test_01 implements Runnable{

    private int count = 100;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count = " + count);
    }

    public static void main(String[] args) {
        Test_01 thread = new Test_01();
        for(int i = 0 ; i < 100 ; i++){
            new Thread(thread,"Thread" + i).start();
        }
    }
}
