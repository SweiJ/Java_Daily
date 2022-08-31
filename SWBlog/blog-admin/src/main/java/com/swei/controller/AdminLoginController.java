package com.swei.controller;

import com.swei.dto.UserDto;
import com.swei.entity.User;
import com.swei.service.AdminLoginService;
import com.swei.utils.ResponseResult;
import com.swei.vo.AdminUserInfoVo;
import com.swei.vo.RouterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-28 14:46
 */
@RestController
public class AdminLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody UserDto userDto) {
        return adminLoginService.login(userDto);
    }

    @GetMapping("/getInfo")
    public ResponseResult<AdminUserInfoVo> getInfo() {
        return adminLoginService.getInfo();
    }

    @GetMapping("/getRouters")
    public ResponseResult<RouterVo> getRouters() {
        return adminLoginService.getRouters();
    }

    @PostMapping("/user/logout")
    public ResponseResult logout() {
        return adminLoginService.logout();
    }
}
