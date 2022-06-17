package com.xxxx.seckill.controller;


import com.xxxx.seckill.pojo.User;
import com.xxxx.seckill.vo.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author swei
 * @since 2022-06-14
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 用户信息(测试)
     * @param user
     * @return
     */
    public RespBean info(User user) {
        return RespBean.success(user);
    }
}

