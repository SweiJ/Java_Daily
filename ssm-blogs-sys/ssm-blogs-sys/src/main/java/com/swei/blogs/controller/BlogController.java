package com.swei.blogs.controller;

import com.swei.blogs.model.Res;
import com.swei.blogs.model.User;
import com.swei.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-27
 * Time: 21:02
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/bloglist")
    public Res getAllBlogs(HttpSession session) {
        return blogService.getAllBlogs(session);
    }

    @RequestMapping("/blogcontent")
    public Res getContentByBlogId(String blogId) {
        int id = Integer.parseInt(blogId);
        return blogService.getContentByBlogId(id);
    }

    @RequestMapping("login")
    public Res getNameBySession(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if(user == null) {
            return Res.error("没有用户");
        }
        user.setPassword("");
        return Res.success("user", user);
    }
}
