package org.example.example.dao.impl;


import org.example.example.dao.UserDao;
import org.example.example.domain.SysUser;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-09
 * Time: 16:22
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("执行了数据库的insert操作!");
    }
}
