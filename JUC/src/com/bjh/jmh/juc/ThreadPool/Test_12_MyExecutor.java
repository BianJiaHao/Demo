package com.bjh.jmh.juc.ThreadPool;

import java.util.concurrent.Executor;

public class Test_12_MyExecutor implements Executor {

    public static void main(String[] args) {
        new Test_12_MyExecutor().execute(()-> System.out.println("Hello Executor"));
    }

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
