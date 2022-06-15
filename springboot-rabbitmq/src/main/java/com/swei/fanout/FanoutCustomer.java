package com.swei.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-10
 * Time: 15:44
 */
@Component
public class FanoutCustomer {
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                exchange = @Exchange(value = "logs", type = "fanout")
            )
    })
    public void receive1(String message) {
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "logs", type = "fanout")
            )
    })
    public void receive2(String message) {
        System.out.println("message2 = " + message);
    }
}
