package com.swei.secsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.swei.secsys.mapper")
public class SecsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecsysApplication.class, args);
    }

}
