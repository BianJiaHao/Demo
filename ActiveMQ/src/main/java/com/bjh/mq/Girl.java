package com.bjh.mq;

import java.io.Serializable;

/**
 * @Author Obito
 * @Date 2020/12/20 上午10:04
 */
public class Girl implements Serializable {

    private static final long serializableUID = 1L;
    private String name;
    private int age;
    private double price;

    public Girl(String name, int age, double price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
