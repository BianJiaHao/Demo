package com.bjh.jmh.juc.ThreadPool;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Test_11_TransferQueue {
    public static void main(String[] args) {

        char[] aI = "123456789".toCharArray();
        char[] aC = "ABCDEFGHI".toCharArray();

        TransferQueue<Character> queue = new LinkedTransferQueue<>();

        new Thread(()->{
          try {
              for(char c : aI){
                  queue.transfer(c);
                  System.out.print(queue.take());
              }
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
        },"t1").start();

        new Thread(()->{
            try {
                for(char c : aC){
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
