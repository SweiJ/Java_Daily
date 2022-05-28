package com.xxx.server.controller;


import com.xxx.server.pojo.Admin;
import com.xxx.server.pojo.ResBean;
import com.xxx.server.pojo.Role;
import com.xxx.server.service.IAdminService;
import com.xxx.server.service.IRoleService;
import com.xxx.server.service.Impl.AdminServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author swei
 * @since 2022-05-05
 */
@RestController
@RequestMapping("/system/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "获取所有操作员")
    @GetMapping("/")
    public List<Admin> getAllAdmins(String keywords) {
        return adminService.getAllAdmins(keywords);
    }

    @ApiOperation(value = "更新操作员")
    @PutMapping("/")
    public ResBean updateAdmin(@RequestBody Admin admin) {
        if(adminService.updateById(admin)) {
            return ResBean.success("更新成功!");
        }
        return ResBean.error("更新失败!");
    }

    @ApiOperation(value = "删除操作员")
    @PutMapping("/{id}")
    public ResBean deleteAdmin(@PathVariable Integer id) {
        if(adminService.removeById(id)) {
            return ResBean.success("删除成功!");
        }
        return ResBean.error("删除失败!");
    }

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @ApiOperation(value = "更新操作员角色")
    @PutMapping("/role")
    public ResBean updateAdminRole(Integer adminId, Integer[] rids) {
        return adminService.updateAdminRole(adminId, rids);
    }
}
