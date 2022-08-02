package com.swei.blogs.service;


import com.swei.blogs.model.Blog;
import com.swei.blogs.model.Res;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-27
 * Time: 21:09
 * @author SweiPC
 */
public interface BlogService {

    /**
     * 获取当前用户所有博客
     * @param session
     * @return
     */
    Res getAllBlogs(HttpSession session);

    /**
     * 根据博客Id获取文章详情
     * @param blogId
     * @return
     */
    Res getContentByBlogId(@Param("blogId") Integer blogId);
}
