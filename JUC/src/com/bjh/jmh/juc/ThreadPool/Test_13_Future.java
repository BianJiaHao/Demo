package com.bjh.jmh.juc.ThreadPool;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Test_13_Future {

    public static void main(String[] args) throws Exception{

        FutureTask<Integer> task = new FutureTask<>(()->{
           TimeUnit.MILLISECONDS.sleep(500);
           return 1000;
        });

        new Thread(task).start();

        System.out.println(task.get());
    }
}
