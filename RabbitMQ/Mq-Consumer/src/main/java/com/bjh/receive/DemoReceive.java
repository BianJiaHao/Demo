package com.bjh.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DemoReceive {
    @RabbitListener(queues = "my")
    public void demo(String msg){
        System.out.println("获取的信息" + msg);
    }
}
