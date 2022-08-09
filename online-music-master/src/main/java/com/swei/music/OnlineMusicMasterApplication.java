package com.swei.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class OnlineMusicMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineMusicMasterApplication.class, args);
    }

}
