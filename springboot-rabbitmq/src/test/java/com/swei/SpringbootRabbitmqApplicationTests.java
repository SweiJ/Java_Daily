package com.swei;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testHello() {
        rabbitTemplate.convertAndSend("hello", "hello word");
    }

    @Test
    public void testWord() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "work 模型" + i);
        }
    }

    @Test
    public void testFanout() {
        rabbitTemplate.convertAndSend("logs", "", "Fanout 模型");
    }

    @Test
    public void testRoute() {
        rabbitTemplate.convertAndSend("directs", "info", "发送info的key的路由信息");
    }

    @Test
    public void testTopic() {
        rabbitTemplate.convertAndSend("topics", "user.save", "发送topic的路由信息");
    }
}
