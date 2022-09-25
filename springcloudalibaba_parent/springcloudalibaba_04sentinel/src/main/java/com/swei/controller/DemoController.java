package com.swei.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-09-14 16:04
 */
@RestController
public class DemoController {

    public static final Logger log = LoggerFactory.getLogger(DemoController.class);


    @RequestMapping("/demo01")
    public String demo() {
        log.info("Demo requested");
        return "Demo";
    }
}
