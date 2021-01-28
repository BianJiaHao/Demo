package com.bjh.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Author Obito
 * @Date 2021/1/20 下午3:46
 */
public class Test01 {

    public static void main(String[] args) {

        Collection list = new ArrayList();

        // 集合有一个特点，只能存放引用数据类型的数据，不能是基本数据类型 基本数据类型会进行自动的装箱成对应的包装类 int - Integer
        list.add(18);
        list.add(19);
        list.add(20);
        list.add(21);
        System.out.println(list);

        List<Integer> asList = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});

        list.addAll(asList);

        System.out.println(list);

        // list.clear();

        list.remove(6);

        System.out.println(list);

        System.out.println(list.size());

        System.out.println(list.isEmpty());

        System.out.println(list.equals(asList));

        System.out.println(list.contains(100));
    }
}
