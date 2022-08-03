package com.swei.blogs.controller;

import com.swei.blogs.model.Res;
import com.swei.blogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-25
 * Time: 21:48
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/login")
    public Res login(String username, String password, HttpSession session) {
        return userService.getUserByName(username, password, session);
    }
}

