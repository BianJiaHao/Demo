package com.bjh.jmh.juc;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock用于替代synchronized
 * 由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 这里是复习synchronized最原始的语义
 *
 * 使用reentrantlock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁（重要的事情说三遍）
 * 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 *
 * 使用reentrantlock可以进行“尝试锁定”tryLock，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 *
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 */
public class Test_15_ReentrantLock_04 {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(()->{
            try {
                lock.lock();
                System.out.println("thread1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("thread1 end");
            } catch (InterruptedException e) {
                System.out.println("1被打断了！");
            }finally {
                lock.unlock();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
           try {
               lock.lockInterruptibly();//可以对interrupt()方法做出响应
               System.out.println("thread2 start");
               TimeUnit.SECONDS.sleep(2);
               System.out.println("thread2 end");
           } catch (InterruptedException e) {
               System.out.println("2被打断了！");
           }finally {
               lock.unlock();
           }
        });
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();//打断线程2的等待
    }
}
