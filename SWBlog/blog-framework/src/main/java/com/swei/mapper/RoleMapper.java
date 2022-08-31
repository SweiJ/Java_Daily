package com.swei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-28 15:41:04
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 查询用户的角色信息
     * @param userId
     * @return
     */
    List<String> selectRoleKeyByUserId(@Param("userId") Long userId);


    /**
     * 逻辑删除标签
     * @param id
     */
    void deleteRoleByIds(@Param("ids") List<String> id);
}
