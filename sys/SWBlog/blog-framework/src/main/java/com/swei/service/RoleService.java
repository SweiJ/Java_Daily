package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2022-08-28 15:41:04
 */
public interface RoleService extends IService<Role> {

    /**
     * 获取角色信息
     * @param userId
     * @return
     */
    List<String> selectRoleKeyByUserId(Long userId);

}

