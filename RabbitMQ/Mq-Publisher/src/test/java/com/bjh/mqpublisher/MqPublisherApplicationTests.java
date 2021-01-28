package com.bjh.mqpublisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MqPublisherApplicationTests {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void test_01(){
		amqpTemplate.convertAndSend("my","sss");
		System.out.println("send success");
	}

}
