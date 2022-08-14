package com.swei.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.music.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-06
 * Time: 20:14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User getUserByName(@Param("username") String username);
}
