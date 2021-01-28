package com.bjh.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author Obito
 * @Date 2021/1/20 下午4:07
 */
public class Test02 {

    public static void main(String[] args) {

        Collection list = new ArrayList();

        list.add(18);
        list.add(19);
        list.add(20);
        list.add(21);

        // 对集合进行遍历
        for(Object o : list){
            System.out.println(o);
        }

        System.out.println("-----------------------");

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
