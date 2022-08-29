package com.swei.service;

import com.swei.entity.User;
import com.swei.utils.ResponseResult;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-25 10:14
 */
public interface BlogLoginService {

    /**
     * 博客登录
     * @param user
     * @return
     */
    ResponseResult login(User user);

    /**
     * 退出登录
     * @return
     */
    ResponseResult logout();

}
