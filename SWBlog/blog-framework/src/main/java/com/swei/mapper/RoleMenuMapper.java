package com.swei.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-30 22:59
 */
@Mapper
public interface RoleMenuMapper {
    /**
     * 修改角色资源关联表
     * @param id
     * @param menuIds
     */
    void insertRoleMenu(@Param("roleId") Long id, @Param("ids") List<String> menuIds);

    /**
     * 删除当前角色拥有的资源关联信息
     * @param id
     */
    void deleteRoleMenuByRoleId(@Param("id") Long id);
}
