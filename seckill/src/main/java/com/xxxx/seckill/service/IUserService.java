package com.xxxx.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.vo.LoginVo;
import com.xxxx.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author swei
 * @since 2022-06-14
 */
public interface IUserService extends IService<User> {
    /**
     * 登录校验
     * @param loginVo
     * @param request
     * @param response
     * @return
     */
    RespBean dologin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);


    /**
     * 根据cookie获取用户
     * @param userToken
     * @return
     */
    User getUserByCookie(String userToken, HttpServletRequest request, HttpServletResponse response);


    /**
     * 更新密码
     * @param userToken
     * @param password
     * @param request
     * @param response
     * @return
     */
    RespBean updatePassword(String userToken, String password, HttpServletRequest request, HttpServletResponse response);
}
