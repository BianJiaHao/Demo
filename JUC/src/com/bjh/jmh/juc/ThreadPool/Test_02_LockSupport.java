package com.bjh.jmh.juc.ThreadPool;

import java.util.concurrent.locks.LockSupport;

public class Test_02_LockSupport {

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] aI = "123456789".toCharArray();
        char[] aC = "ABCDEFGHI".toCharArray();

        t1 = new Thread(()->{
            for(char c : aI){
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(()->{
            for(char c : aC){
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
