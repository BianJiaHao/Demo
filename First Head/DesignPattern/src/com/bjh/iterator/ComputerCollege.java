package com.bjh.iterator;

import java.util.Iterator;

public class ComputerCollege implements College{

    private Department[] departments;
    private int numofDepartment = 0;

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("Java","Java");
        addDepartment("PHP","PHP");
        addDepartment("大数据","大数据");

    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String des) {
        Department department = new Department(name, des);
        departments[numofDepartment] = department;
        numofDepartment += 1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeInterator(departments);
    }
}
