package com.swei.service.impl;

import com.swei.mapper.BlogMapper;
import com.swei.model.Blog;
import com.swei.model.Res;
import com.swei.model.User;
import com.swei.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-27
 * Time: 21:10
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Res getAllBlogs(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer userId = user.getUserId();
        List<Blog> allBlogs = blogMapper.getAllBlogs(userId);
        if(allBlogs == null) {
            return Res.error("错误!");
        }
        return Res.success("返回结果", allBlogs);
    }
}
