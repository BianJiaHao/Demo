package com.bjh.reflect;

import com.bjh.pojo.Person;

import java.lang.reflect.Field;

/**
 * @Author Obito
 * @Date 2021/1/24 上午9:49
 */
public class ClassAPI {

    public static void main(String[] args) throws Exception{

        // 获取成员变量 包括子类和父类 同时只能包含公共的方法
        Class<?> clazz = Class.forName("com.bjh.pojo.Person");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getModifiers());
        }

        System.out.println("----------------");

        // 次方法返回的是当前类的所有属性，不仅仅局限于公共访问修饰符，所有的访问修饰符都可以拿到
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }

        System.out.println("----------------");

        // 反射在一定意义上破坏了封装性
        Field name = clazz.getDeclaredField("name");
        // 设置该属性是否能被访问 true表示能被访问，破坏了封装性
        name.setAccessible(true);
        System.out.println(name.getName());
        Object o = clazz.newInstance();
        name.set(o,"Obito");
        System.out.println(((Person)o).getName());

        System.out.println("----------------");
    }
}
