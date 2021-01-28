package com.bjh.jmh.juc.ThreadPool;

import javafx.concurrent.Task;

import java.io.IOException;
import java.util.concurrent.*;

public class Test_15_HelloThreadpool {

    static class Task implements Runnable{

        private int i;

        public Task(int i){
            this.i = i;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "i=" + i +
                    '}';
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Task" + " " + i);
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        TimeUnit unit;
        BlockingQueue workQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4), Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 8; i++) {
            threadPoolExecutor.execute(new Task(i));
        }
        System.out.println(threadPoolExecutor.getQueue());

        threadPoolExecutor.execute(new Task(100));

        System.out.println(threadPoolExecutor.getQueue());

        threadPoolExecutor.shutdown();
    }
}
