package com.swei.service.impl;

import com.swei.bean.User;
import com.swei.service.UserService;
import com.swei.utils.BusinessException;
import com.swei.utils.UserIO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-20
 * Time: 14:26
 */
public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO = new UserIO();
        userIO.add(user);
        userIO.writeUsers();
        return user;
    }
}
