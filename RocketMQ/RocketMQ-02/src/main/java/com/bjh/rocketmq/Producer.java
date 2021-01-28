package com.bjh.rocketmq;

import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 事务消息
 * @Author Obito
 * @Date 2020/12/25 上午9:11
 */
public class Producer {

    public static void main(String[] args) throws Exception{

        TransactionMQProducer producer = new TransactionMQProducer("TranProducer");
        producer.setNamesrvAddr("39.97.215.166:9876");

        producer.setTransactionListener(new TransactionListener() {
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                /**
                 * 执行本地事务
                 * 同步执行
                 */
                System.out.println("-----执行本地事务-----");
                System.out.println("Msg:" + " " + new String(message.getBody()) + "," + "Id:" + message.getTransactionId());
                return LocalTransactionState.UNKNOW;
            }

            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                /**
                 * Broker 端回调，检查事务
                 */
                System.out.println("-----检查事务-----");
                System.out.println("Msg:" + " " + new String(messageExt.getBody()) + "," + "Id:" + messageExt.getTransactionId());
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });

        producer.start();
        TransactionSendResult sendResult = producer.sendMessageInTransaction(new Message("myTopic", "测试消息".getBytes()), false);
        System.out.println("返回结果：" + " " + sendResult);
    }
}
