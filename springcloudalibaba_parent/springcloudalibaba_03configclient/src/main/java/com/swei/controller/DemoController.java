package com.swei.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-09-13 15:44
 */
@RestController
@RefreshScope // 允许远端配置修改自动刷新
public class DemoController {

    public static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Value("${cususername}")
    private String name;

    @RequestMapping("/demo")
    public String demo() {
        log.info("Demo requested");
        return "Demo" + name;
    }
}
