package com.swei.ui;

import com.swei.bean.User;
import com.swei.service.impl.UserServiceImpl;
import com.swei.utils.BusinessException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-21
 * Time: 11:04
 */
public class Login extends BaseClass {
    public User login() {
        System.out.println(getR("input.username"));
        String name = input.nextLine();
        System.out.println(getR("input.password"));
        String password = input.nextLine();
        UserServiceImpl userService = new UserServiceImpl();
        User login = userService.login(name, password);
        if(login == null) {
            throw new BusinessException("login.error");
        } else {
            return login;
        }
    }
}
