package org.example.service.Impl;

import lombok.Getter;
import lombok.Setter;
import org.example.dao.Impl.UserMapperImpl;
import org.example.pojo.User;
import org.example.service.UsersService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-07
 * Time: 15:39
 */
@Setter
public class UsersServiceImpl implements UsersService {

    private UserMapperImpl userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
