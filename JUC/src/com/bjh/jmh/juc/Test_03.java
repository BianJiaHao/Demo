package com.bjh.jmh.juc;

import java.util.concurrent.TimeUnit;

/**
 * 面试题：模拟银行账户
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 这样行不行？
 * 容易产生脏读问题（dirtyRead）
 */
public class Test_03 {

    static class Account{

        String name;
        double balance;

        public synchronized void setBalance(String name,Double balance){
            this.name = name;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.balance = balance;
        }

        public double getBalance(String name){
            return this.balance;
        }
    }

    public static void main(String[] args) {

        Account account = new Account();
        new Thread(()->account.setBalance("Obito",100.00)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance("Obito"));

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance("Obito"));

    }
}
