package com.bjh.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Author Obito
 * @Date 2020/12/18 下午2:36
 * 接受消息
 */
public class Receiver_Queue {

    public static void main(String[] args) throws Exception{

        // 获取连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
               "admin","admin",
                "tcp://localhost:61616"
        );

        // 添加信任的持久化类型
        ArrayList<String> list = new ArrayList<String>();
        list.add(Girl.class.getPackage().getName());
        connectionFactory.setTrustedPackages(list);

        // 获取一个向ActiveMQ的连接
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // 获取Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 找目的地，获取destination，消费端，也会从这个目的地取消息
        Queue queue = session.createQueue("user");
        Destination dlq = session.createQueue("xxooQ.user");

        // 获取消息
        MessageConsumer consumer = session.createConsumer(queue);
        MessageConsumer consumer1 = session.createConsumer(dlq);

        // 监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                System.out.println("start");
                if(message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }else if(message instanceof ObjectMessage){
                    ObjectMessage objectMessage = (ObjectMessage) message;
                    try {
                        Girl girl = (Girl) objectMessage.getObject();
                        System.out.println(girl.getName() + girl.getAge() + girl.getPrice());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }else if(message instanceof BytesMessage){
                    BytesMessage bytesMessage = (BytesMessage) message;
                    FileOutputStream out = null;
                    try {
                        out = new FileOutputStream("/Users/bianjiahao/Desktop/aaa.txt");
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                    byte[] by = new byte[1024];
                    int len = 0 ;
                    try {
                        while((len = bytesMessage.readBytes(by))!= -1){
                            out.write(by,0,len);
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }else if (message instanceof MapMessage){
                    MapMessage mapMessage = (MapMessage) message;
                    try {
                        System.out.println(mapMessage.getString("name"));
                        System.out.println(mapMessage.getInt("age"));
                        System.out.println(mapMessage.getDouble("price"));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        /**
         *  死信队列
         */
        consumer1.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if (message instanceof MapMessage){
                    MapMessage mapMessage = (MapMessage) message;
                    System.out.println("DLQ");
                    try {
                        System.out.println(mapMessage.getString("name"));
                        System.out.println(mapMessage.getInt("age"));
                        System.out.println(mapMessage.getDouble("price"));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

//        while (true){
//            // 阻塞
//            TextMessage message = (TextMessage) consumer.receive();
//            System.out.println("消息为：" + message.getText());
//
//            message.acknowledge();
//        }

    }
}
