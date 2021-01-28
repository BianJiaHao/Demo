package com.bjh.jmh.juc;


import com.sun.xml.internal.xsom.XSUnionSimpleType;

/**
 * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
 */
public class Test_09 {
    private static class Data{
        int a;
        int b;

        public Data(int a,int b){
            this.a = a;
            this.b = b;
        }
    }

    volatile static Data data;

    public static void main(String[] args) {
        Thread writer = new Thread(()->{
           for(int i = 0;i<1000;i++){
               data = new Data(i,i);
           }
        });
        Thread reader = new Thread(()->{
           while (data == null){}
           int x = data.a;
           int y = data.b;
           if(x != y){
               System.out.printf("a = %s, b=%s%n", x, y);
           }
        });

        reader.start();
        writer.start();

        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }


}
