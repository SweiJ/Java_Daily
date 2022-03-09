package org.example.dao.impl;

import org.example.dao.UserDao;
import org.example.domain.SysUser;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-09
 * Time: 16:22
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("执行了数据库的insert操作!");
    }
}
