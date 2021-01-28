package com.bjh.jmh.juc.ThreadPool;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Test_18_FixedThreadPool {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        getPrime(1,200000);

        long end = System.currentTimeMillis();

        System.out.println("Main线程执行的结果 ：" + " " + (end - start));

        System.out.println("-------------------------------");

        final int cpuCores = 4;

        ExecutorService service = Executors.newFixedThreadPool(cpuCores);

        MyTask t1 = new MyTask(1,80000);
        MyTask t2 = new MyTask(80001,130000);
        MyTask t3 = new MyTask(130001,170000);
        MyTask t4 = new MyTask(170001,200000);

        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);

        long start_1 = System.currentTimeMillis();

        f1.get();
        f1.get();
        f1.get();
        f1.get();

        long end_1 = System.currentTimeMillis();

        System.out.println("FixedThreadPool执行的结果 ：" + " " + (end_1 - start_1));


    }

    static class MyTask implements Callable<List<Integer>>{

        int startPos , endPos;

        public MyTask(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> prime = getPrime(startPos, endPos);
            return prime;
        }
    }

    static boolean isPrime(int num){
        for (int i = 2; i <= num/2; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    static List<Integer> getPrime(int start , int end){
        List<Integer> results = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if(isPrime(i)){
                results.add(i);
            }
        }
        return results;
    }
}
