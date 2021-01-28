package com.bjh.dao;

import com.bjh.pojo.Person;

/**
 * @Author Obito
 * @Date 2021/1/19 下午4:07
 */
public interface PersonDao {
    public void insert(Person person);
    public void deleteById(Integer id);
    public void deleteByName(String name);
}
