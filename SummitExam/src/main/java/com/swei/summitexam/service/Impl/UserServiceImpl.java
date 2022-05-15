package com.swei.summitexam.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swei.summitexam.dao.UserDao;
import com.swei.summitexam.model.DataMessage;
import com.swei.summitexam.model.PaperUser;
import com.swei.summitexam.model.UserParam;
import com.swei.summitexam.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public DataMessage adduser(PaperUser paperuser) {
        DataMessage message = new DataMessage();
        if(paperuser.getUserName() == null || "".equals(paperuser.getUserName())) {
            message.setMessage("用户名为空, 请输入用户名!");
            return message;
        }
        if(paperuser.getPwd() == null || "".equals(paperuser.getPwd())) {
            message.setMessage("密码为空, 请输入用户名!");
            return message;
        }

        QueryWrapper<PaperUser> qw = new QueryWrapper<>();
        qw.eq("user_name", paperuser.getUserName());
        PaperUser paperuser1 = userDao.selectOne(qw);
        if(paperuser1 == null) {
            userDao.insert(paperuser);
            message.setSuccess(true);
        } else {
            message.setMessage("用户名重复, 请重新输入");
        }
        return message;
    }

    @Override
    public DataMessage login(PaperUser paperuser, HttpSession session) {
        DataMessage message = new DataMessage();

        QueryWrapper<PaperUser> qw = new QueryWrapper<>();

        qw.eq("user_name", paperuser.getUserName());
        qw.eq("pwd", paperuser.getPwd());
        PaperUser paperuser1 = userDao.selectOne(qw);
        if (paperuser1 == null) {
            message.setMessage("登陆失败, 用户名或者密码错误");
        } else {
            session.setAttribute("message", "登陆成功");
            message.setSuccess(true);
            message.setMessage(paperuser.getUserName());
        }
        return message;
    }

    @Override
    public DataMessage updatapwd(UserParam userParam) {
        DataMessage message = new DataMessage();

        QueryWrapper<PaperUser> qw = new QueryWrapper<>();
        qw.eq("user_name", userParam.getUserName());
        qw.eq("pwd", userParam.getOldpwd());

        PaperUser paperuser = userDao.selectOne(qw);
        if (paperuser == null) {
            message.setMessage("原密码输入错误");
        } else {
            if (userParam.getNewpwd() == null || userParam.getNewpwd2() == null) {
                message.setMessage("新密码为空, 请输入密码");
            } else if (!userParam.getNewpwd().equals(userParam.getNewpwd2())) {
                message.setMessage("密码不一致, 请重新输入!");
            } else {
                PaperUser paperuser1 = new PaperUser();
                paperuser1.setPwd(userParam.getNewpwd());
                userDao.update(paperuser1, qw);
                message.setMessage("密码修改成功");
            }
        }
        return message;
    }

    @Override
    public DataMessage layout(HttpServletRequest request) {
        DataMessage message = new DataMessage();
        request.getSession().invalidate();
        message.setMessage("退出系统成功");
        return message;
    }
}
