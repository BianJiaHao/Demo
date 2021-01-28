package com.bjh.test;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @Author Obito
 * @Date 2021/1/24 下午4:47
 * 测试nio下的ByteBuffer
 */
public class WhatIsByteBuffer {

    @Test
    public  void whatByteBuffer(){

        // 第一种分配方式 分配在堆上
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 第二种分配方式 分配在堆外
        ByteBuffer buffer2 = ByteBuffer.allocateDirect(1024);

        System.out.println("Postition" + " " + buffer.position());
        System.out.println("Limit" + " " +buffer.limit());
        System.out.println("Capacity" + " " +buffer.capacity());
        System.out.println("Mark" + " " +buffer);

        buffer.put("123".getBytes());

        System.out.println("----- put 123 -----");
        System.out.println("Mark" + " " +buffer);

        // 读写的交替
        buffer.flip();

        System.out.println("----- flip -----");
        System.out.println("Mark" + " " + buffer);

        buffer.get();

        System.out.println("----- get -----");
        System.out.println("Mark" + " " + buffer);

        buffer.compact();

        System.out.println("----- compact -----");
        System.out.println("Mark" + " " + buffer);


    }

}
