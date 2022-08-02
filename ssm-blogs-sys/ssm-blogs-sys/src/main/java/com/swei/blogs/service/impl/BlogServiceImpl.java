package com.swei.blogs.service.impl;

import com.swei.blogs.mapper.BlogMapper;
import com.swei.blogs.model.Blog;
import com.swei.blogs.model.Res;
import com.swei.blogs.model.User;
import com.swei.blogs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
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
        for (Blog allBlog : allBlogs) {
            String content = allBlog.getContent();
            if(content.length() > 50) {
                allBlog.setContent(content.substring(0, 50) + "...");
            }
        }
        return Res.success("返回结果", allBlogs);
    }

    @Override
    public Res getContentByBlogId(Integer blogId) {
        Blog blog = blogMapper.getContentByBlogId(blogId);
        if(blog == null) {
            return Res.success("无博客!");
        }
        return Res.success("OK", blog);
    }
}
