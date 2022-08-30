package com.swei.mapper;

import com.swei.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-30 9:14
 */
@Mapper
public interface UserRoleMapper {


    /**
     * 根据角色查询是否还存在用户
     * @param ids
     * @return
     */
    int selectUserRoleByRoleIds(@Param("ids") List<String> ids);

    /**
     * 新增用户角色
     * @param roleIds
     */
    void addUserRole(@Param("userId") Long userId, @Param("ids") List<String> roleIds);

    /**
     * 根据用户名查询所拥有的角色信息
     * @param id
     */
    List<RoleVo> selectUserRoleByUserId(@Param("userId") String id);

    /**
     * 删除原有的用户角色关联信息
     * @param id
     */
    void deleteUserRoleByUserIds(@Param("ids") List<String> id);
}
