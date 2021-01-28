package com.bjh.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author Obito
 * @Date 2020/12/18 下午2:36
 * 接受消息
 */
public class Receiver_Topic {

    public static void main(String[] args) throws Exception{

        // 获取连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
               "admin","admin",
                "tcp://localhost:61616"
        );

        // 获取一个向ActiveMQ的连接
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // 获取Session
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        // 找目的地，获取destination，消费端，也会从这个目的地取消息
        Destination topic = session.createTopic("user");

        // 获取消息
        MessageConsumer consumer = session.createConsumer(topic);
        while (true){
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("消息为：" + message.getText());

            message.acknowledge();
        }

    }
}
