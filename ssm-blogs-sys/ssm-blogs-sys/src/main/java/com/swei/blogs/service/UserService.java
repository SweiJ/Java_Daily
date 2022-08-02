package com.swei.blogs.service;

import com.swei.blogs.model.Res;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-26
 * Time: 20:42
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    Res getUserByName(String username, String password, HttpSession session);
}
