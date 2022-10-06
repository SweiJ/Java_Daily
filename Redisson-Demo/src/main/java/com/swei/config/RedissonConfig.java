package com.swei.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-10-06 10:25
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        // 配置
        Config redissonConfig = new Config();

        redissonConfig.useSingleServer().setAddress("192.168.80.10").setPassword("");

        // 创建redisson对象
        return Redisson.create(redissonConfig);
    }
}
