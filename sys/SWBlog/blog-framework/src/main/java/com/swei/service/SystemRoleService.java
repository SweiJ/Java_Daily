package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.dto.RoleListDto;
import com.swei.entity.Role;
import com.swei.utils.ResponseResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 17:58
 */
public interface SystemRoleService extends IService<Role> {

    /**
     * 获取角色列表
     * @param pageNum
     * @param pageSize
     * @param roleListDto
     * @return
     */
    ResponseResult getRoleList(Integer pageNum, Integer pageSize, RoleListDto roleListDto);

    /**
     * 新增角色
     * @param role
     * @return
     */
    ResponseResult addRole(Role role);

    /**
     * 逻辑删除角色
     * @param id
     * @return
     */
    ResponseResult deleteRole(List<String> id);

    /**
     * 获取角色
     * @param id
     * @return
     */
    ResponseResult getRole(String id);

    /**
     * 更新角色
     * @param role
     * @return
     */
    ResponseResult updateRole(Role role);
}
