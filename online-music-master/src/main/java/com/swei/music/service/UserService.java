package com.swei.music.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.music.model.Role;
import com.swei.music.model.User;
import com.swei.music.util.Res;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-06
 * Time: 20:21
 */
public interface UserService extends IService<User> {

//    List<Role> getRoles(Integer id);

//    Res<Map<String, String>> login(String username, String password, HttpServletRequest request);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    Res<User> getUserByName(String username, String password, HttpServletResponse response);
}
