package com.bjh.producer.config;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Obito
 * @Date 2021/1/19 上午8:46
 */
@Configuration
public class MQProducerConfig {

    private static final Logger logger = LoggerFactory.getLogger(MQProducerConfig.class);

    @Bean
    public DefaultMQProducer getRocketMQProducer() throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("Group1");
        producer.setNamesrvAddr("39.97.215.166:9876");
        producer.start();
        logger.debug("RocketMQ start");
        return producer;
    }
}
