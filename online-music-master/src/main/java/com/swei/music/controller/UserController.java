package com.swei.music.controller;

import com.swei.music.model.User;
import com.swei.music.service.UserService;
import com.swei.music.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
    private UserService userServie;

    @RequestMapping("/login")
    public Res<User> login(@RequestParam User user, HttpServletResponse response) {
        return userServie.getUserByName(user.getUsername(), user.getPassword(), response);
    }

}
