package com.xxx.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-05
 * Time: 11:22
 * @author SweiPC
 */
@SpringBootApplication
@MapperScan("com.xxx.server.mapper")
public class OnlineApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineApplication.class, args);
    }
}
