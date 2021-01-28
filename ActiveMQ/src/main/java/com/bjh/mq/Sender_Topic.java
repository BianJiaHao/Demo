package com.bjh.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author Obito
 * @Date 2020/12/18 上午10:35
 * 消息发送
 */
public class Sender_Topic {

    public static void main(String[] args) throws Exception{

        // 获取连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "admin","admin",
                "tcp://localhost:61616"
        );

        // 获取一个向ActiveMQ的连接
        Connection connection = connectionFactory.createConnection();

        // 获取Session
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        // 找目的地，获取destination，消费端，也会从这个目的地取消息
        Destination topic = session.createTopic("user");

        // 向目的地写入消息
        MessageProducer producer = session.createProducer(topic);

        // 持久化设置
        // producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        // 创建消息
        for (int i = 0; i < 100; i++) {
            TextMessage textMessage = session.createTextMessage("hi" + i);
            producer.send(textMessage);
            // TimeUnit.SECONDS.sleep(1);
            // session.commit();
        }

        // 关闭连接
        connection.close();
        System.out.println("发送成功！");


    }
}
