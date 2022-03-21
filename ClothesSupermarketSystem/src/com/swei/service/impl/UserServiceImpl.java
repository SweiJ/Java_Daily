package com.swei.service.impl;

import com.swei.bean.User;
import com.swei.service.UserService;
import com.swei.utils.BusinessException;
import com.swei.utils.UserIO;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-20
 * Time: 14:26
 */
public class UserServiceImpl implements UserService {
    UserIO userIO = new UserIO();
    @Override
    public User register(User user) throws BusinessException {
        userIO.add(user);
//        userIO.writeUsers();
        return user;
    }

    @Override
    public User login(String name, String password) {
        // 登陆当前的用户名和密码是否在列表中
        return new UserIO().userIsTrue(name, password);
    }
}
