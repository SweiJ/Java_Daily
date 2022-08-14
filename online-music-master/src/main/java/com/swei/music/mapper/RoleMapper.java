package com.swei.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.music.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-10
 * Time: 21:32
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoles(@Param("id") Integer id);
}
