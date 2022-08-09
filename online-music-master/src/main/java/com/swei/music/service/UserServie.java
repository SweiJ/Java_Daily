package com.swei.music.service;

import com.swei.music.model.User;
import com.swei.music.util.Res;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-06
 * Time: 20:21
 */
public interface UserServie {

    /**
     * 根据用户名查找用户
     * @param username
     * @param password
     * @param request
     * @return
     */
    Res<User> getUserByName(String username, String password, HttpServletRequest request);
}
