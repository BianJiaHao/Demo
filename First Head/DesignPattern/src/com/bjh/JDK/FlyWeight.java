package com.bjh.JDK;

public class FlyWeight {
    public static void main(String[] args) {
        /**
         * 如果Integer.valueOf(x) x在-128 - 127 之间，就是使用享元模式返回
         * 如果不在范围内，则仍然new
         * 小结：
         *      1 在valueOf方法中，先判断是否在IntegerCache中，如果不在，就创建新的Integer new
         *      否则，就直接从缓存池中返回
         *      2 valueOf 方法，就使用到了享元模式
         */
        Integer x = Integer.valueOf(127);
        Integer y = new Integer(127);
        Integer z = Integer.valueOf(127);
        Integer w = new Integer(127);

        System.out.println(x.equals(y));
        System.out.println(x == y);
        System.out.println(x == z);
        System.out.println(w == x);
        System.out.println(w == y);

        System.out.println("--------------------");

        Integer x1 = Integer.valueOf(200);
        Integer x2 = Integer.valueOf(200);
        System.out.println(x1 == x2);
    }

}
