package com.bjh.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 消息发送者(异步发送消息)
 * @Author Obito
 * @Date 2020/12/24 上午9:38
 */
public class Producer_02 {

    public static void main(String[] args) throws Exception{

        // 创建发送者
        DefaultMQProducer producer = new DefaultMQProducer("xxoo");

        // 设置nameserver的地址
        producer.setNamesrvAddr("39.97.215.166:9876");
        producer.start();

        // 异步可靠消息  不会阻塞等待确认，采用事件监听方式接受broker返回的确认
        Message message = new Message("myTopic","hi".getBytes());
        producer.send(message, new SendCallback() {

            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
                System.out.println("返回结果：" + " " + sendResult);
            }

            public void onException(Throwable throwable) {
                // 如果发生异常，尝试重投或者调整业务逻辑
                System.out.println("消息发送异常");
            }
        });

        //producer.shutdown();
        System.out.println("已经停机");
    }
}
