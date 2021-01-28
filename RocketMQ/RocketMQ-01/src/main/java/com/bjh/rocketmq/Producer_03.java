package com.bjh.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 消息发送者(只管发消息，不保证一定发送成功,单向消息)
 * @Author Obito
 * @Date 2020/12/24 上午9:38
 */
public class Producer_03 {

    public static void main(String[] args) throws Exception{

        // 创建发送者
        DefaultMQProducer producer = new DefaultMQProducer("xxoo");

        // 设置nameserver的地址
        producer.setNamesrvAddr("39.97.215.166:9876");
        producer.start();

        // 单向消息 p 网络的不稳定很有可能丢消息
        Message message = new Message("myTopic","hi".getBytes());
        producer.sendOneway(message);

        producer.shutdown();
        System.out.println("已经停机");
    }
}
