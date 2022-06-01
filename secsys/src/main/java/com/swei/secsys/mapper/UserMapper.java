package com.swei.secsys.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.secsys.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-29
 * Time: 15:19
 * @author SweiPC
 */
public interface UserMapper extends BaseMapper<User>  {
    User getUserByUsername(@Param("username") String username);
}
