package com.bjh.service;

import com.bjh.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyPersonService extends Remote {
    public List<Person> findAll() throws RemoteException;
}
