package com.bjh.activemq02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.ArrayList;

/**
 * @Author Obito
 * @Date 2020/12/20 下午7:26
 */
@Service
public class SenderService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(String destination , String msg){

        ArrayList<String> list = new ArrayList<>();
        list.add("Obito");
        list.add("OrererereO");
        jmsMessagingTemplate.convertAndSend(destination,list);

    }

    public void send2(String destination , String msg){
        jmsTemplate.send(destination,new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("xxoo");
                textMessage.setStringProperty("hehe","enen");
                return textMessage;
            }
        });
    }

}
