package com.swei.summitexam.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swei.summitexam.dao.UserDao;
import com.swei.summitexam.model.Paperuser;
import com.swei.summitexam.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 10:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public Map<String, Object> adduser(Paperuser paperuser) {
        Map<String, Object> map = new HashMap<>();
        if(paperuser.getUserName() == null || "".equals(paperuser.getUserName())) {
            map.put("message", "用户名为空, 请输入用户名!");
            return map;
        }
        if(paperuser.getPwd() == null || "".equals(paperuser.getPwd())) {
            map.put("message", "密码为空, 请输入用户名!");
            return map;
        }

        QueryWrapper<Paperuser> qw = new QueryWrapper<>();
        qw.eq("user_name", paperuser.getUserName());
        Paperuser paperuser1 = userDao.selectOne(qw);
        if(paperuser1 == null) {
            userDao.insert(paperuser);
            map.put("success", true);
            return map;
        } else {
            map.put("message", "用户名重复, 请重新输入");
            return map;
        }
    }

    @Override
    public Map<String, Object> login(Paperuser paperuser, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<Paperuser> qw = new QueryWrapper<>();

        qw.eq("user_name", paperuser.getUserName());
        qw.eq("pwd", paperuser.getPwd());
        Paperuser paperuser1 = userDao.selectOne(qw);
        if(paperuser1 == null) {
            map.put("message", "登陆失败, 用户名或者密码错误");
            return map;
        } else {
            request.getSession().setAttribute("user", paperuser.getUserName());
//            session.setAttribute("pwd", paperuser.getPwd());
            map.put("success", true);
            map.put("message", paperuser.getUserName());
            return map;
        }
    }

    @Override
    public Map<String, Object> updatapwd(String userName, String oldpwd, String newpwd) {
        Map<String, Object> map = new HashMap<>();
        QueryWrapper<Paperuser> qw = new QueryWrapper<>();
        qw.eq("user_name", userName);
        qw.eq("pwd", oldpwd);

        Paperuser paperuser = userDao.selectOne(qw);
        if (paperuser == null) {
            map.put("message", "原密码输入错误");
            return map;
        } else {
            if(newpwd == null) {
                map.put("message", "新密码为空, 请输入密码");
                return map;
            } else {
                Paperuser paperuser1 = new Paperuser();
                paperuser1.setPwd(newpwd);
                userDao.update(paperuser1, qw);
                map.put("message", "密码修改成功");
                return map;
            }
        }
    }

    @Override
    public Map<String, Object> layout(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.getSession().invalidate();
        map.put("message", "退出系统成功");
        return map;
    }
}
