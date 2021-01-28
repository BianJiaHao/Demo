package com.bjh.linkedlist;

import java.util.LinkedList;

/**
 * @Author Obito
 * @Date 2021/1/23 下午1:52
 */
public class Test01 {

    public static void main(String[] args) {

        // 创建一个LinkedList集合对象
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("a");

        System.out.println(linkedList);

        linkedList.addFirst("aa");
        linkedList.addLast("aa");
        linkedList.offer("kk");
        System.out.println(linkedList.poll());

        System.out.println(linkedList);
    }
}
