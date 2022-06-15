package com.swei.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-10
 * Time: 15:30
 */
@Component // 持久化 非独占 不是自动删除队列
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class HelloCustomer {

    @RabbitHandler
    public void receivel(String message) {
        System.out.println("message = " + message);
    }
}
