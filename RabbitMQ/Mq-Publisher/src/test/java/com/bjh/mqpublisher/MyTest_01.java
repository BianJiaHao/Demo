package com.bjh.mqpublisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MyTest_01 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void test_01(){
        amqpTemplate.convertAndSend("my","it's a message");
        System.out.println("send success");
    }
}
