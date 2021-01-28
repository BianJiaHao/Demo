package com.bjh.service.impl;

import com.bjh.Person;
import com.bjh.service.MyPersonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MyPersonServiceImpl extends UnicastRemoteObject implements MyPersonService {

    public MyPersonServiceImpl() throws RemoteException {
    }

    public List<Person> findAll() throws RemoteException {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person(1,"张三"));
        personList.add(new Person(2,"李四"));
        return personList;
    }
}
