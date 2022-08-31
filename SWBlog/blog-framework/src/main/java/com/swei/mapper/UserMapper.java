package com.swei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-25 09:48:44
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(@Param("ids") List<String> id);
}
