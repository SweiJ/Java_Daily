package com.swei.secsys.controller;

import com.swei.secsys.pojo.Res;
import com.swei.secsys.pojo.User;
import com.swei.secsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-29
 * Time: 11:06
 */
@RestController
@RequestMapping("/sec")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Res login(@RequestBody User user, HttpServletRequest request) {
        return userService.login(user, request);
    }
}
