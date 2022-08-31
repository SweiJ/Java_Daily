package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.entity.User;
import com.swei.utils.ResponseResult;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-25 16:37
 */
public interface UserService extends IService<User> {

    /**
     * 查询个人信息
     * @return
     */
    ResponseResult userInfo();

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    ResponseResult updateUserInfo(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    ResponseResult register(User user);
}
