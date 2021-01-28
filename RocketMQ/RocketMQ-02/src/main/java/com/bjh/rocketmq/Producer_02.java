package com.bjh.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * 指定队列发送消息
 * @Author Obito
 * @Date 2020/12/25 下午4:00
 */
public class Producer_02 {

    public static void main(String[] args) throws Exception{

        DefaultMQProducer producer = new DefaultMQProducer("producer");
        producer.setNamesrvAddr("39.97.215.166:9876");
        producer.start();

        /**
         * message:要发送的消息
         * new MessageQueueSelector():queue选择器
         * arg:外部传入的参数可以指定选择哪一个queue
         * timeout：超时时间
         */
        for (int i = 0; i < 20; i++) {
            Message message = new Message("msg", ("第" + i + "条消息").getBytes());
            producer.send(message, new MessageQueueSelector() {
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    MessageQueue queue = list.get(0);
                    return queue;
                }
            },0,2000);
        }

        for (int i = 0; i < 20; i++) {
            Message message = new Message("msg", ("第" + i + "条消息").getBytes());
            producer.send(message, new MessageQueueSelector() {
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    MessageQueue queue = list.get(1);
                    return queue;
                }
            },1,2000);
        }

        for (int i = 0; i < 20; i++) {
            Message message = new Message("msg", ("第" + i + "条消息").getBytes());
            producer.send(message, new MessageQueueSelector() {
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    MessageQueue queue = list.get(2);
                    return queue;
                }
            },2,2000);
        }

        for (int i = 0; i < 20; i++) {
            Message message = new Message("msg", ("第" + i + "条消息").getBytes());
            producer.send(message, new MessageQueueSelector() {
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    MessageQueue queue = list.get(3);
                    return queue;
                }
            },3,2000);
        }

        System.out.println("消息发送成功");
    }
}
