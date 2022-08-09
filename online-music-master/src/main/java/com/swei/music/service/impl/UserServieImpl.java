package com.swei.music.service.impl;

import com.swei.music.mapper.UserMapper;
import com.swei.music.model.User;
import com.swei.music.service.UserServie;
import com.swei.music.util.Constant;
import com.swei.music.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-06
 * Time: 20:23
 */
@Service
public class UserServieImpl implements UserServie {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    public Res<User> getUserByName1(String username, String password, HttpServletRequest request) {
//        User userLogin = new User();
//        userLogin.setUsername(username);
//        userLogin.setPassword(password);
//
//        User user = userMapper.getUserByName(userLogin);
//        if(user != null) {
//            request.getSession().setAttribute(Constant.USERINFO_LOGIN_KEY, user);
//            System.out.println("登录成功!");
//            return new Res<>(0, "登录成功!", userLogin);
//        } else {
//            System.out.println("登录失败");
//            return new Res<>(-1, "登录失败!", null);
//        }
//    }

    /**
     * 根据用户名查找用户
     * @param username
     * @param password
     * @param request
     * @return
     */
    @Override
    public Res<User> getUserByName(String username, String password, HttpServletRequest request) {

        User user = userMapper.getUserByName(username);
        if(user != null) {
            if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return new Res<>(-1, "用户名或密码错误!", user);
            }
            request.getSession().setAttribute(Constant.USERINFO_LOGIN_KEY, user);
            return new Res<>(0, "登录成功!", user);
        } else {
            return new Res<>(-1, "用户名或密码错误!", null);
        }
    }


}
