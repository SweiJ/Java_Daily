package com.swei.secsys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.secsys.pojo.Res;
import com.swei.secsys.pojo.Role;
import com.swei.secsys.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-29
 * Time: 15:05
 */
public interface UserService extends IService<User> {
    User getAdminByUserName(String username);

    Res login(User user, HttpServletRequest request);

    List<Role> getRoles(Integer id);
}
