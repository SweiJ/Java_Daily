package com.swei.controller;

import com.swei.SystemException;
import com.swei.entity.User;
import com.swei.service.BlogLoginService;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-25 10:07
 */
@RestController
public class BlogLoginController {

    @Autowired
    private BlogLoginService blogLoginService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        if(!StringUtils.hasText(user.getUserName())) {
            // 提示必须传用户名
//            throw new RuntimeException(("请输入用户名!"));
            throw new SystemException(HttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout() {
        return blogLoginService.logout();
    }

}
