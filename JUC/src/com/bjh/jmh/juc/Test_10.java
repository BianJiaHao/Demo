package com.bjh.jmh.juc;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
 * 运行下面的程序，并分析结果
 * *对比上一个程序，可以用synchronized解决，synchronized可以保证可见性和原子性，volatile只能保证可见性
 */
public class Test_10 {
    volatile int count = 0;

    /*synchronized*/ public void m(){
        for(int i=0;i<10000;i++){

            count++;
        }
    }

    public static void main(String[] args) {
        Test_10 t = new Test_10();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0;i<10;i++){
            threads.add(new Thread(t::m,"thread-"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
