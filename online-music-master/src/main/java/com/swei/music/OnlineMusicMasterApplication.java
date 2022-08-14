package com.swei.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.swei.music.mapper")
public class OnlineMusicMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineMusicMasterApplication.class, args);
    }

}
