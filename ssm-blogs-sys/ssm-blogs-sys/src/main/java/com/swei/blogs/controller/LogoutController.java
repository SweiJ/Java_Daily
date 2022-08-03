package com.swei.blogs.controller;

import com.swei.blogs.model.Res;
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
public class LogoutController {

    @RequestMapping("/layout")
    public Res layout(HttpSession session) {
        if(session == null) {
            return Res.error("当前用户尚未登录!");
        }

        session.removeAttribute("user");
        return Res.success("成功退出登录");
    }
}
