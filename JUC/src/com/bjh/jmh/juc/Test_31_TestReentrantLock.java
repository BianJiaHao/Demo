package com.bjh.jmh.juc;

import java.util.concurrent.locks.ReentrantLock;

public class Test_31_TestReentrantLock {
    private static volatile int i = 0;



    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();

        lock.unlock();
    }
}
