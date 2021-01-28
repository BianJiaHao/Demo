package com.bjh;

import java.io.Serializable;

public class Person implements Serializable {
    private Integer id;
    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "com.bjh.People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
