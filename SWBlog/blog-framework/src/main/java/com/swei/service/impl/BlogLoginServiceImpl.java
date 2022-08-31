package com.swei.service.impl;

import com.swei.constants.SystemConstants;
import com.swei.entity.LoginUser;
import com.swei.entity.User;
import com.swei.service.BlogLoginService;
import com.swei.utils.*;
import com.swei.vo.BlogUserLoginVo;
import com.swei.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-25 10:15
 */
@Service
public class BlogLoginServiceImpl implements BlogLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        if(Objects.isNull(authenticate)) {
            throw new RuntimeException("用户或密码错误!");
        }
        // 获取userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();

        // 把用户存入redis
        String jwt = JwtUtil.createJWT(userId);
        redisCache.setCacheObject(SystemConstants.BLOGLOGIN + userId, loginUser);

        // 把token和userInfo封装返回
        // 把User转换成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        BlogUserLoginVo blogUserLoginVo = new BlogUserLoginVo(jwt, userInfoVo);

        return ResponseResult.okResult(blogUserLoginVo);
    }

    /**
     * 退出登录
     * @return
     */
    @Override
    public ResponseResult logout() {
        // 获取用户id
        Long userId = SecurityUtils.getUserId();

        // 删除redis中token
        redisCache.deleteObject(SystemConstants.ADMINLOGIN + userId);
        return ResponseResult.okResult();
    }
}
