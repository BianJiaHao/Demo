package com.bjh.jmh.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决同样的问题的更高效的方法，使用AtomXXX类
 * AtomXXX类本身方法都是原子性的，但不能保证多个方法连续调用是原子性的
 */
public class Test_11 {
    int count1 = 0;
    AtomicInteger count = new AtomicInteger(0);
    public void m(){
        for(int i=0;i<1000;i++){
            count.incrementAndGet();//count++
        }
    }

    public static void main(String[] args) {
        Test_11 t = new Test_11();
        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);

    }
}

