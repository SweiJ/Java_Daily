package org.example.controller;

import lombok.Getter;
import lombok.Setter;
import org.example.dao.Impl.UserMapperImpl;
import org.example.pojo.User;
import org.example.service.UsersService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-07
 * Time: 15:45
 */
@Setter
public class UserController {
    private UsersService usersService;

    public int insert(User user) {
        return usersService.insert(user);
    }
}
