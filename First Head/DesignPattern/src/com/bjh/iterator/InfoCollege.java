package com.bjh.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College{

    List<Department> departments = new ArrayList<>();

    public InfoCollege() {
        addDepartment("信息安全技术","安全");
        addDepartment("信息安全技术1","安全1");
        addDepartment("信息安全技术2","安全2");
    }

    @Override
    public String getName() {
        return "信息技术学院";
    }

    @Override
    public void addDepartment(String name, String des) {
        Department department = new Department(name, des);
        departments.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoColleageIterator(departments);
    }
}
