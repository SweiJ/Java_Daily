package com.swei.service;

import com.swei.dto.UserDto;
import com.swei.entity.User;
import com.swei.utils.ResponseResult;
import com.swei.vo.AdminUserInfoVo;
import com.swei.vo.RouterVo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-28 14:48
 */
public interface AdminLoginService {
    /**
     * 后台登录
     * @param userDto
     * @return
     */
    ResponseResult login(UserDto userDto);

    /**
     * 获取权限信息
     * @return
     */
    ResponseResult<AdminUserInfoVo> getInfo();

    /**
     * 获取路由信息
     * @return
     */
    ResponseResult<RouterVo> getRouters();

    /**
     * 退出登录
     * @return
     */
    ResponseResult logout();
}
