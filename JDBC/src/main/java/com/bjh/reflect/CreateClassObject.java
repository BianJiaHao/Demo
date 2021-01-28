package com.bjh.reflect;

import com.bjh.pojo.Person;

/**
 * @Author Obito
 * @Date 2021/1/24 上午9:31
 */
public class CreateClassObject {

    public static void main(String[] args) {

        try {
            Class<?> clazz = Class.forName("com.bjh.pojo.Person");
            System.out.println(clazz.getPackage());
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());
            System.out.println(clazz.getCanonicalName());

            Class<Person> personClass = Person.class;

            Person person = new Person();
            Class<? extends Person> aClass = person.getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
