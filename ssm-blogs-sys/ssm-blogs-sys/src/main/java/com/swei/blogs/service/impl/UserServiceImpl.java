package com.swei.blogs.service.impl;

import com.swei.blogs.mapper.UserMapper;
import com.swei.blogs.model.Res;
import com.swei.blogs.model.User;
import com.swei.blogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-26
 * Time: 20:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Res getUserByName(String username, String password, HttpSession session) {
        if(!StringUtils.hasLength(username) && !StringUtils.hasLength(password)) {
            return Res.error("当前用户名或密码为空!");
        }
        User user = userMapper.getUserByName(username);
        if(user == null || !user.getPassword().equals(password)) {
            return Res.error("用户名或密码错误!");
        }

        session.setAttribute("user", user);

        return Res.success("登录成功!");
    }
}
