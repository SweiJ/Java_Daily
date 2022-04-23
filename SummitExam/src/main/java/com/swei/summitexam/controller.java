package com.swei.summitexam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-23
 * Time: 15:54
 */

@RestController
public class controller {

    @RequestMapping("/hello")
    public String hello() {
        return "helloword";
    }
}
