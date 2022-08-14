package com.swei.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-11
 * Time: 11:49
 */
@Controller
public class LoginController {

    @RequestMapping("/index")
    public String login() {
        return "login.html";
    }
}
