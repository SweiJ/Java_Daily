package com.swei.secsys.controller;

import com.swei.secsys.pojo.Res;
import com.swei.secsys.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-01
 * Time: 15:10
 */
@RestController
@RequestMapping("/sec")
public class DataController {

    @Autowired
    private DataService dataService;

    /**
     * 删除用户 没有指定具体用户 属于有权限操作
     * @return
     */
    @DeleteMapping("/user")
    public Res deleteUser() {
        return dataService.deleteUser();
    }

    /**
     * 在数据库中没有该权限 匿名权限都可以访问
     * @return
     */
    @GetMapping("/use")
    public Res Hello() {
        return Res.success("hello");
    }

    @GetMapping("/test")
    public Res test() {
        return Res.success("test ok");
    }
}
