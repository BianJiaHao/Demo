package com.bjh.activemq02.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @Author Obito
 * @Date 2020/12/20 下午7:40
 */
@Service
public class ReceiverService {

    @JmsListener(destination = "user",containerFactory = "jmsListenerContainerTopic")
    public void receiver(String msg){
        System.out.println("收到消息：" + " " + msg);
    }

}
