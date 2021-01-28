package com.bjh.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * 消费者
 * @Author Obito
 * @Date 2020/12/24 上午10:50
 */
public class Consumer {

    public static void main(String[] args) throws Exception{

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("xxoocsm");

        consumer.setNamesrvAddr("39.97.215.166:9876");

        // 每个消费者只能关注一个topic  第一个参数topic：关注消息的地址 第二个参数：过滤器 *：代表不过滤
        MessageSelector selector = MessageSelector.bySql("age >= 18 and age <= 28");
        consumer.subscribe("myTopic",selector);

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for(MessageExt msg : list){
                    System.out.println(new String(msg.getBody()));
                }
                // 默认情况下，这条消息只会被一个消费者消费 点对点
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.start();
        System.out.println("-----消费者已经上线-----");
    }
}
