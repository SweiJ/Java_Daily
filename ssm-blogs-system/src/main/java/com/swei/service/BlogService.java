package com.swei.service;

import com.swei.model.Blog;
import com.swei.model.Res;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-27
 * Time: 21:09
 * @author SweiPC
 */
public interface BlogService {

    Res getAllBlogs(HttpSession session);
}
