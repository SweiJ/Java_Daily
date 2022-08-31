package com.swei.controller;

import com.swei.entity.User;
import com.swei.service.UserService;
import com.swei.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-27 18:19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 返回用户信息
     * @return
     */
    @GetMapping("/userInfo")
    public ResponseResult userInfo() {
        return userService.userInfo();
    }


    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping("/userInfo")
    public ResponseResult updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user) {
        return userService.register(user);
    }
}
