package com.swei.mapper;

import com.swei.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-25
 * Time: 21:47
 */
@Mapper
public interface UserMapper {

    /**
     * 根据名字查询用户
     * @param username
     * @return
     */
    User getUserByName(@Param("username") String username);

}
