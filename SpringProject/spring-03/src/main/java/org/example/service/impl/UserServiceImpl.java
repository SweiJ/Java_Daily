package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.example.domain.SysUser;
import org.example.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-09
 * Time: 16:19
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = null;


    @Override
    public void addUser(SysUser user) {
        userDao.insertUser(user);
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
