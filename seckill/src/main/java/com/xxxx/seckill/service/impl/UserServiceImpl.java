package com.xxxx.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.seckill.exception.GlobalException;
import com.xxxx.seckill.mapper.UserMapper;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.service.IUserService;
import com.xxxx.seckill.utils.CookieUtil;
import com.xxxx.seckill.utils.MD5Util;
import com.xxxx.seckill.utils.UUIDUtil;
import com.xxxx.seckill.utils.ValidatorUtil;
import com.xxxx.seckill.vo.LoginVo;
import com.xxxx.seckill.vo.RespBean;
import com.xxxx.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author swei
 * @since 2022-06-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public RespBean dologin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();

        // 判断输入的手机号和密码是否存在长度
        if(!StringUtils.hasLength(mobile) || !StringUtils.hasLength(password)) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        // 判断手机号是否有效
//        if(!ValidatorUtil.isMobile(mobile)) {
//            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//        }

        // 数据库是否存在用户
        User user = userMapper.selectById(mobile);
        if(null == user) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        // 对密码进行二次加密并且查询是否与数据库中的密码一致
        if(!MD5Util.formPassToDBPass(password, user.getSlat()).equals(user.getPassword())) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        // 生成cookie
        String token = UUIDUtil.uuid();
        // 将用户信息存入redis
        redisTemplate.opsForValue().set("user:" + token, user);

//        request.getSession().setAttribute(token, user);
        CookieUtil.setCookie(request, response, "userToken", token);
        return RespBean.success();
    }

    @Override
    public User getUserByCookie(String userToken, HttpServletRequest request, HttpServletResponse response) {
        if(!StringUtils.hasLength(userToken)) {
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + userToken);
        if(null != user) {
            CookieUtil.setCookie(request, response, "userToken", userToken);
        }
        return user;
    }

    @Override
    public RespBean updatePassword(String userToken, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = getUserByCookie(userToken, request, response);
        if(null == user) {
            throw  new GlobalException(RespBeanEnum.MOBILE_NOT_EXIST);
        }
        user.setPassword(MD5Util.inputPassToDBPass(password, user.getSlat()));
        int result = userMapper.updateById(user);
        if(1 == result) {
            redisTemplate.delete("user:" + userToken);
            return RespBean.success();
        }
        return RespBean.error(RespBeanEnum.PASSWORD_UPDATE_FAIL);
    }


}
