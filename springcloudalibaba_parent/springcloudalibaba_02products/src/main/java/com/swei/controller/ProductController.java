package com.swei.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-09-13 10:53
 */
@RestController
public class ProductController {
    public static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Value("${server.port}")
    private  int port;
    @GetMapping("/product")
    public String product(Integer id) {
        log.info("id: {}", id);
        return "商品服务返回: " + id + "当前提供服务端口号为: " + port;
    }
}
