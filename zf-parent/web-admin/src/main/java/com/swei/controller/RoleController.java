package com.swei.controller;

import com.swei.entity.Role;
import com.swei.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-22
 * Time: 20:45
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping
    public String index(Map map) {
        // 调用RoleService方法获取所有角色
        List<Role> roleList = roleService.findAll();

        // 将所有的角色放到request域中
        map.put("list", roleList);

        // 渲染数据页面
        return "role/index";
    }

}
