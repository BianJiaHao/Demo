package com.bjh.consumer.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Author Obito
 * @Date 2021/1/19 上午8:56
 */
@Configuration
public class MQConsumerConfig {

    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer() throws Exception{
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("Group1");
        consumer.setNamesrvAddr("39.97.215.166:9876");
        consumer.subscribe("Topic1","*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println("OK!");
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        return consumer;
    }
}
