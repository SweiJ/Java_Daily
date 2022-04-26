package com.swei.summitexam.controller;

import com.swei.summitexam.model.Paperuser;
import com.swei.summitexam.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 9:42
 */
@RequestMapping("/paper-user")
@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/zhuce")
    public Map<String, Object> register(Paperuser paperuser) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(paperuser.getUserName());
        System.out.println(paperuser.getPwd());

        map = userService.adduser(paperuser);
        return map;
    }

    @RequestMapping("/login")
    public Map<String, Object> login(Paperuser paperuser, HttpSession session) {

        return userService.login(paperuser, session);
    }

    @RequestMapping("/updatePwd")
    public Map<String, Object> updataPwd(String userName, String oldpwd, String newpwd) {
        System.out.println(userName);
        System.out.println(oldpwd);
        System.out.println(newpwd);
        return userService.updatapwd(userName, oldpwd, newpwd);
    }

    @RequestMapping("/layout")
    public Map<String, Object> layout(HttpServletRequest request) {
        return userService.layout(request);
    }
}
