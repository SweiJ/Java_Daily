package com.swei.ui;

import com.swei.bean.User;
import com.swei.service.impl.UserServiceImpl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-20
 * Time: 14:19
 * @author SweiPC
 */
public class Register extends BaseClass {
    public void register() {
        System.out.println(getR("input.username"));
        String name = input.nextLine();
        System.out.println(getR("input.password"));
        String password = input.nextLine();
        User user = new User(name, password);
        UserServiceImpl userService = new UserServiceImpl();
        userService.register(user);
    }
}
