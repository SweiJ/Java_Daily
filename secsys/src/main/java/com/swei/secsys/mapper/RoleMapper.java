package com.swei.secsys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.secsys.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-29
 * Time: 16:03
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoles(@Param("id") Integer id);
}
