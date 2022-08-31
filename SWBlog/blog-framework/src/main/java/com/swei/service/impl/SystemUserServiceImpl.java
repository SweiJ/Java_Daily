package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.constants.SystemConstants;
import com.swei.dto.AddUserDto;
import com.swei.dto.UserListDto;
import com.swei.entity.User;
import com.swei.mapper.UserMapper;
import com.swei.mapper.UserRoleMapper;
import com.swei.service.RoleService;
import com.swei.service.SystemRoleService;
import com.swei.service.SystemUserService;
import com.swei.utils.BeanCopyUtils;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.PageVo;
import com.swei.vo.RoleVo;
import com.swei.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 17:35
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<UserMapper, User> implements SystemUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private SystemRoleService systemRoleService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户列表
     * @param pageNum
     * @param pageSize
     * @param userListDto
     * @return
     */
    @Override
    public ResponseResult getUserList(Integer pageNum, Integer pageSize, UserListDto userListDto) {
        // 分页
        LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<>();
        userWrapper.like(StringUtils.hasText(userListDto.getUserName()), User::getUserName, userListDto.getUserName());
        userWrapper.like(StringUtils.hasText(userListDto.getNickName()), User::getNickName, userListDto.getNickName());
        userWrapper.eq(StringUtils.hasText(userListDto.getStatus()), User::getStatus, userListDto.getStatus());

        Page<User> page = new Page<>(pageNum, pageSize);

        page(page, userWrapper);

        PageVo pageVo = new PageVo(page.getRecords(), page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 新增用户
     * @param addUserDto
     * @return
     */
    @Override
    public ResponseResult addUser(AddUserDto addUserDto) {
        if(!StringUtils.hasText(addUserDto.getUserName())) {
            throw new SystemException(HttpCodeEnum.USER_IS_NULL);
        }

        // 加密
        String encode = bCryptPasswordEncoder.encode(addUserDto.getPassword());
        addUserDto.setPassword(encode);

        // 转换为用户插入数据库
        User user = BeanCopyUtils.copyBean(addUserDto, User.class);
        // 用户类型  如果需求变更后期需要改进 包含2的话为普通用户
        if(addUserDto.getRoleIds().contains(SystemConstants.ROLE_ID_TYPE)) {
            user.setType(SystemConstants.USER_COMMON_TYPE);
        } else {
            user.setType(SystemConstants.USER_ADMIN_TYPE);
        }
        save(user);

        // 新增角色
        userRoleMapper.addUserRole(user.getId(), addUserDto.getRoleIds());

        return ResponseResult.okResult();
    }

    /**
     * 逻辑删除用户
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteUser(List<String> id) {
        // 删除用户
        userMapper.deleteUser(id);

        // 删除用户所对应的角色关联信息
        userRoleMapper.deleteUserRoleByUserIds(id);

        return ResponseResult.okResult();
    }

    /**
     * 获取当前用户
     * @param id
     * @return
     */
    @Override
    public ResponseResult getUser(String id) {

        // 获取当前用户信息
        User user = getById(id);
        // 获取当前用户角色名称和id
//        List<RoleVo> roleVos = userRoleMapper.selectUserRoleByUserId(id);

        // 获取所有的角色
        List<RoleVo> roleVos = (List<RoleVo>) systemRoleService.listAllRole().getData();

        // 获取当前用户所有角色id列表
        List<RoleVo> roleVoList = userRoleMapper.selectUserRoleByUserId(id);

        List<String> roleIds = roleVoList.stream()
                .map(roleVo -> String.valueOf(roleVo.getId()))
                .collect(Collectors.toList());

        UserVo userVo = new UserVo(user, roleVos, roleIds, user.getPassword());

        return ResponseResult.okResult(userVo);
    }

    /**
     * 更新当前用户 bug: 前端修改角色时先修改 这时并不会看到角色栏变化 实则已经变了
     * @param user
     * @return
     */
    @Override
    @Transactional
    public ResponseResult updateUser(User user) {

        // 更新user信息
        updateById(user);

        // 更新角色信息
        // 删除原来该用户存在的角色信息
        List<String> userIds = new ArrayList<>();
        userIds.add(String.valueOf(user.getId()));

        userRoleMapper.deleteUserRoleByUserIds(userIds);

        if(!ObjectUtils.isEmpty(user.getRoleIds())) {
            // 获取该用户修改之后的所有角色id
            List<String> roleIds = user.getRoleIds();

            userRoleMapper.addUserRole(user.getId(), roleIds);
        }

        return ResponseResult.okResult();
    }
}
