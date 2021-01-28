package com.bjh.service;

import com.bjh.service.impl.MyPersonServiceImpl;
import org.apache.zookeeper.*;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ProviderRun {
    public static void main(String[] args) throws Exception{
        MyPersonService myPersonService = new MyPersonServiceImpl();
        LocateRegistry.createRegistry(8989);
        String url = "rmi://localhost:8989/myPersonService";
        Naming.bind(url,myPersonService);
        System.out.println("服务启动成功");
        //创建zookeeper并发送消息
        ZooKeeper zooKeeper = new ZooKeeper("39.97.215.166:2181", 10000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println("获取连接");
            }
        });
        zooKeeper.create("/rpc/provider",url.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println("注册成功");


    }
}
