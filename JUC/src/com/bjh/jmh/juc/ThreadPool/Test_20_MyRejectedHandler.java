package com.bjh.jmh.juc.ThreadPool;

import java.util.concurrent.*;

public class Test_20_MyRejectedHandler {

    public static void main(String[] args) {

        ExecutorService service = new ThreadPoolExecutor(4,4,0, TimeUnit.SECONDS
                ,new ArrayBlockingQueue<>(4),new MyHandler());
    }

    static class MyHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        }
    }
}
