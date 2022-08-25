package com.swei.ordermeal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.ordermeal.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-14 21:40
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
