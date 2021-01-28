package com.bjh.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * 消息发送者(同步发送消息)
 * @Author Obito
 * @Date 2020/12/24 上午9:38
 */
public class Producer {

    public static void main(String[] args) throws Exception{

        // 创建发送者
        DefaultMQProducer producer = new DefaultMQProducer("xxoo");

        // 设置nameserver的地址
        producer.setNamesrvAddr("39.97.215.166:9876");
        producer.start();

        // 两个参数，topic：消息将要发送到的地址与msg绑定 body：消息中的具体内容
        Message message = new Message("myTopic","HelloWorld".getBytes());
        // 同步消息发送，等待broker返回确认信号
        producer.send(message);

        producer.shutdown();
        System.out.println("已经停机");
    }
}
