package com.swei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 开启eureka服务
public class EurekaServerApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplicaiton.class, args);
    }

}
