package com.swei.ordermeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan("com.swei.ordermeal.filter")
@EnableTransactionManagement
public class OrderMealMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMealMasterApplication.class, args);
    }

}
