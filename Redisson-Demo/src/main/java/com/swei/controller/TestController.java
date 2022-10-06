package com.swei.controller;

import com.swei.config.RedissonConfig;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-10-06 10:24
 */
@RestController
public class TestController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/")
    public String test() throws InterruptedException {
        RLock order = redissonClient.getLock("order");

        order.tryLock(1L, TimeUnit.MILLISECONDS);

        return "success";
    }
}
