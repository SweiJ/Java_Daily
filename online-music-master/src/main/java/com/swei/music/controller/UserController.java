package com.swei.music.controller;

import com.swei.music.model.User;
import com.swei.music.service.UserServie;
import com.swei.music.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-06
 * Time: 20:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServie userServie;

    @RequestMapping("/login")
    public Res<User> login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        return userServie.getUserByName(username, password, request);
    }

}
