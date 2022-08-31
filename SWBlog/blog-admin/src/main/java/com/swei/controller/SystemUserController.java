package com.swei.controller;

import com.swei.dto.AddUserDto;
import com.swei.dto.UserListDto;
import com.swei.entity.User;
import com.swei.service.SystemUserService;
import com.swei.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 17:32
 */
@RestController
@RequestMapping("/system/user")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    /**
     * 获取用户列表信息
     * @param pageNum
     * @param pageSize
     * @param userListDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult getUserList(Integer pageNum, Integer pageSize, UserListDto userListDto) {
        return systemUserService.getUserList(pageNum, pageSize, userListDto);
    }

    /**
     * 新增用户
     * @param addUserDto
     * @return
     */
    @PostMapping
    public ResponseResult addUser(@RequestBody AddUserDto addUserDto) {
        return systemUserService.addUser(addUserDto);
    }

    /**
     * 逻辑删除和批量删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteUser(@PathVariable List<String> id) {
        return systemUserService.deleteUser(id);
    }

    /**
     * 获取当前用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getUser(@PathVariable String id) {
        return systemUserService.getUser(id);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping
    public ResponseResult updateUser(@RequestBody User user) {
        return systemUserService.updateUser(user);
    }

}
