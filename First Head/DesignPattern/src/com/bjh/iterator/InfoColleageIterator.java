package com.bjh.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoColleageIterator implements Iterator {

    List<Department> departments = new ArrayList<>();

    int index = -1;

    public InfoColleageIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(index >= departments.size()-1){
            return false;
        }else {
            index += 1;
            return true;
        }

    }

    @Override
    public Object next() {
        return departments.get(index);
    }

    @Override
    public void remove() {

    }
}
