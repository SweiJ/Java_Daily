package com.swei.controller;

import com.swei.mapper.BlogMapper;
import com.swei.model.Res;
import com.swei.service.BlogService;
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

    @RequestMapping("bloglist")
    public Res getAllBlogs(HttpSession session) {
        return blogService.getAllBlogs(session);
    }
}
