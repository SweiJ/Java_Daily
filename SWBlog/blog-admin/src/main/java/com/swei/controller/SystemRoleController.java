package com.swei.controller;

import com.swei.dto.RoleListDto;
import com.swei.entity.Role;
import com.swei.service.SystemRoleService;
import com.swei.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 17:55
 */
@RestController
@RequestMapping("/system/role")
public class SystemRoleController {

    @Autowired
    private SystemRoleService systemRoleService;

    /**
     * 获取角色列表信息
     * @param pageNum
     * @param pageSize
     * @param roleListDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult getRoleList(Integer pageNum, Integer pageSize, RoleListDto roleListDto) {
        return systemRoleService.getRoleList(pageNum, pageSize, roleListDto);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @PostMapping
    public ResponseResult addRole(@RequestBody Role role) {
        return systemRoleService.addRole(role);
    }

    /**
     * 逻辑删除和批量删除角色
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteRole(@PathVariable List<String> id) {
        return systemRoleService.deleteRole(id);
    }

    /**
     * 获取当前角色信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getRole(@PathVariable String id) {
        return systemRoleService.getRole(id);
    }

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    @PutMapping
    public ResponseResult updateRole(@RequestBody Role role) {
        return systemRoleService.updateRole(role);
    }

    @GetMapping("/listAllRole")
    public ResponseResult listAllRole() {
        return systemRoleService.listAllRole();
    }

}
