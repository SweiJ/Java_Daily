package com.swei.summitexam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan //scans from the package of the annotated class (@WebServlet, @WebFilter, and @WebListener)
@MapperScan("com.swei.summitexam.dao")
public class SummitExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SummitExamApplication.class, args);
    }
}
