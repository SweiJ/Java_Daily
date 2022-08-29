package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.dto.UserListDto;
import com.swei.entity.User;
import com.swei.utils.ResponseResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 17:35
 */
public interface SystemUserService extends IService<User> {

    /**
     * 获取用户列表信息
     * @param pageNum
     * @param pageSize
     * @param userListDto
     * @return
     */
    ResponseResult getUserList(Integer pageNum, Integer pageSize, UserListDto userListDto);

    /**
     * 新增用户
     * @param user
     * @return
     */
    ResponseResult addUser(User user);

    /**
     * 逻辑删除用户
     * @param id
     * @return
     */
    ResponseResult deleteUser(List<String> id);

    /**
     * 获取当前用户
     * @param id
     * @return
     */
    ResponseResult getUser(String id);

    /**
     * 更新当前用户
     * @param user
     * @return
     */
    ResponseResult updateUser(User user);
}
