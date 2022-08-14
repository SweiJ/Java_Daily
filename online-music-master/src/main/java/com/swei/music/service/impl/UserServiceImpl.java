package com.swei.music.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.music.mapper.RoleMapper;
import com.swei.music.mapper.UserMapper;
import com.swei.music.model.Role;
import com.swei.music.model.User;
//import com.swei.music.model.UserDetail;
import com.swei.music.service.ResourceService;
import com.swei.music.service.UserService;
import com.swei.music.util.Constant;
import com.swei.music.util.JwtTokenUtil;
import com.swei.music.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-06
 * Time: 20:23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

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
     * @param response
     * @return
     */
    @Override
    public Res<User> getUserByName(String username, String password, HttpServletResponse response) {

        User user = userMapper.getUserByName(username);
        if(user != null) {
            if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return new Res<>(-1, "用户名或密码错误!", null);
            }
            user.setPassword("");

            StpUtil.login(user.getId().toString());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
//            request.getSession().setAttribute(Constant.USERINFO_LOGIN_KEY, user);
            response.setHeader(tokenInfo.getTokenName(), tokenInfo.getTokenValue());
            return new Res<>(0, "登录成功!", user);
        } else {
            return new Res<>(-1, "用户名或密码错误!", null);
        }
    }

}
