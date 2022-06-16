package com.xxxx.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-14
 * Time: 16:10
 */
@Controller
public class PageController {

    @RequestMapping("/pages")
    public String Page(@PathVariable String page) {
        System.out.println(page);
        return page;
    }

}
