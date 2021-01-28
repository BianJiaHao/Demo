package com.bjh.producer.controller;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Obito
 * @Date 2021/1/19 上午8:33
 */
@RestController
public class MainController {

    @Autowired
    DefaultMQProducer producer;

    @RequestMapping("/send")
    public Object send() throws Exception{
        Message message = new Message("Topic1", "xxoo".getBytes());
        return producer.send(message);
    }
}
