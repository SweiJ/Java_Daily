package com.swei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-24 10:51
 */
@EnableScheduling
@EnableSwagger2
@SpringBootApplication
public class SWFrontApplication {
    public static void main(String[] args) {
        SpringApplication.run(SWFrontApplication.class, args);
    }
}
