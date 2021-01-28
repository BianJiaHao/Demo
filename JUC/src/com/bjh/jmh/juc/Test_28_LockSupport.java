package com.bjh.jmh.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class Test_28_LockSupport {

    static Thread t1 = null;
    static Thread t2 = null;

    volatile List list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {


        Test_28_LockSupport t = new Test_28_LockSupport();

        t2 = new Thread(()->{
            System.out.println("t2 start");

            if(t.size() != 5){
                LockSupport.park();
            }

            System.out.println("t2 end");

            LockSupport.unpark(t1);
        });

        t2.start();

        t1 = new Thread(()->{
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add" + " " + i);
                if(t.size() == 5){
                    LockSupport.unpark(t2);
                    LockSupport.park(t1);
                }
            }
        });

        t1.start();
    }
}
