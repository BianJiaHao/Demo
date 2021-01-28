package com.bjh.jmh.juc;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Test_23_AtomicVsSyncVsLonggAdder {
    static AtomicLong count1 = new AtomicLong(0L);
    static long count2 = 0L;
    static LongAdder count3 = new LongAdder();
    static Long[] AllTime = new Long[3];

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count1.incrementAndGet();
                }
            });
        }

        long start = System.currentTimeMillis();

        for(Thread t : threads)
            t.start();

        for(Thread t : threads)
            t.join();

        long end = System.currentTimeMillis();

        Long AtomicTime = end - start;

        System.out.println("Atomic" + " " + count1.get() + " " + "time" + " " + AtomicTime);

        System.out.println("-----------------------------");

        Object lock = new Object();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    synchronized (lock){
                        count2++;
                    }
                }
            });
        }

        long start_2 = System.currentTimeMillis();

        for(Thread t : threads)
            t.start();

        for(Thread t : threads)
            t.join();

        long end_2 = System.currentTimeMillis();

        Long SyncTime = end_2 - start_2;

        System.out.println("Sync" + " " + count2 + " " + "time" + " " + SyncTime);

        System.out.println("-----------------------------");

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count3.increment();
                }
            });
        }

        long start_3 = System.currentTimeMillis();

        for(Thread t : threads)
            t.start();

        for(Thread t : threads)
            t.join();

        long end_3 = System.currentTimeMillis();

        Long LongAdderTime = end_3 - start_3;

        System.out.println("LongAdder" + " " + count3.longValue() + " " + "time" + " " + LongAdderTime);

        System.out.println("-----------------------------");

        AllTime = new Long[]{AtomicTime,SyncTime,LongAdderTime};

        Long BestTime = 0L;

        for (int i = 0; i < AllTime.length ; i++) {
            for (int j = 0; j <AllTime.length ; j++) {
                if(AllTime[i] < AllTime[j]){
                    BestTime = AllTime[i];
                    //swap(AllTime,i,j);
                }else if(AllTime[i] > AllTime[j]){
                    BestTime = AllTime[j];
                }
            }
        }

        System.out.println("最快的时间是" + " " + BestTime);

//        System.out.println("-----------------------------");
//
//        for (int i = 0; i < AllTime.length; i++) {
//            System.out.print(AllTime[i] + " ");
//        }

    }

    static void swap(Long[] longs, int  i , int j){
        Long tmp = longs[i];
        longs[i] = longs[j];
        longs[j] = tmp;
    }


}
