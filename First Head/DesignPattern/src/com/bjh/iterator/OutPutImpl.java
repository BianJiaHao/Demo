package com.bjh.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutPutImpl {
    List<College> colleges = new ArrayList<>();

    public OutPutImpl(List<College> colleges) {
        this.colleges = colleges;
    }

    public void printCollege(){
        Iterator<College> iterator = colleges.iterator();
        while (iterator.hasNext()){
            College college = iterator.next();
            System.out.println("学院的名称：" + " " + college.getName());
            printDepartment(college.createIterator());

        }
    }

    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department department = (Department) iterator.next();
            System.out.println(department.getName() + " " + department.getDes() );
        }
    }
}
