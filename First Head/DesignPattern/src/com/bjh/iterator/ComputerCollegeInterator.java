package com.bjh.iterator;

import java.util.Iterator;

public class ComputerCollegeInterator implements Iterator {

    //我们需要的Department是以什么样的形式存放
    Department[] departments;
    //遍历的位置
    int position = 0;
   

    //构造器
    public ComputerCollegeInterator(Department[] departments) {
        this.departments = departments;
    }

    //判断是否还有下一个元素
    @Override
    public boolean hasNext() {
        if( position >= departments.length || departments[position] == null ){
            return false;
        }else {
            return true;
        }

    }

    //返回下一个元素
    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }

    @Override
    public void remove() {

    }
}
