package com.bjh.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author Obito
 * @Date 2020/12/18 上午10:35
 * 消息发送
 */
public class Sender_Queue {

    public static void main(String[] args) throws Exception{

        // 获取连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "admin","admin",
                "nio://localhost:61616"
        );

        // 获取一个向ActiveMQ的连接
        Connection connection = connectionFactory.createConnection();

        // 获取Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 找目的地，获取destination，消费端，也会从这个目的地取消息
        Queue queue = session.createQueue("user");

        // 向目的地写入消息
        MessageProducer producer = session.createProducer(queue);
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        // 发送序列化对象
//        Girl girl = new Girl("lucy", 18, 400.00);
//        ObjectMessage objectMessage = session.createObjectMessage(girl);
//        producer.send(objectMessage);

        // 字节流 图 小文件
//        BytesMessage bytesMessage = session.createBytesMessage();
//        bytesMessage.writeUTF("hello");
//        bytesMessage.writeBoolean(false);
//        producer.send(bytesMessage);


        // 消息的延时发送以及重复次数
        TextMessage textMessage = session.createTextMessage("hi");
        textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY,5 * 1000);
        textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT,9);
        textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD,2 * 1000);
        producer.send(textMessage);

        // map
//        for (int i = 0; i < 100; i++) {
//            MapMessage mapMessage = session.createMapMessage();
//            mapMessage.setString("name","lucy");
//            mapMessage.setInt("age",18+i);
//            mapMessage.setDouble("price",200.00);
//            // 进行分组 在并发的情况下能够起到负载均衡 定向的分发
//            mapMessage.setLongProperty("week" , i % 7);
//            // 当ttl到期，进入死信队列，保证一些时效性的这种消息
//            producer.setTimeToLive(1000);
//            producer.send(mapMessage);
//        }

        // 持久化设置
        // producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        // 创建消息
//        for (int i = 0; i < 100; i++) {
//            TextMessage textMessage = session.createTextMessage("hi" + i);
//            producer.send(textMessage);
//            TimeUnit.SECONDS.sleep(1);
//            // session.commit();
//        }

        // 关闭连接
        connection.close();
        System.out.println("发送成功！");


    }
}
