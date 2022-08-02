package com.swei.blogs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.swei.blogs.model")
public class SsmBlogsSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsmBlogsSysApplication.class, args);
	}

}
