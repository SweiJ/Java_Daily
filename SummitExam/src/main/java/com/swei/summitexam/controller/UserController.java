package com.swei.summitexam.controller;

import com.swei.summitexam.model.DataMessage;
import com.swei.summitexam.model.PaperUser;
import com.swei.summitexam.model.UserParam;
import com.swei.summitexam.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public DataMessage register(PaperUser paperuser) {
        System.out.println(paperuser.getUserName());
        System.out.println(paperuser.getPwd());

        return userService.adduser(paperuser);
    }

    @RequestMapping("/login")
    public DataMessage login(PaperUser paperuser, HttpSession session) {

        return userService.login(paperuser, session);
    }

    @RequestMapping("/updatePwd")
    public DataMessage updataPwd(UserParam userParam) {
        System.out.println(userParam);
        return userService.updatapwd(userParam);
    }

    @RequestMapping("/layout")
    public DataMessage layout(HttpServletRequest request) {
        return userService.layout(request);
    }
}
