package org.example.dao.Impl;

import org.example.dao.UserMapper;
import org.example.pojo.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-07
 * Time: 15:45
 */
public class UserMapperImpl implements UserMapper {
    @Override
    public int insert(User user) {
        System.out.println(user.getName() + "插入输入成功!");
        return 1;
    }
}
