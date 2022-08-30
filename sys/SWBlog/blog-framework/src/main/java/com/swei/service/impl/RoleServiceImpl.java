package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.constants.SystemConstants;
import com.swei.entity.Menu;
import com.swei.entity.Role;
import com.swei.mapper.RoleMapper;
import com.swei.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swei.service.RoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2022-08-28 15:41:04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 获取角色信息
     * @param userId
     * @return
     */
    @Override
    public List<String> selectRoleKeyByUserId(Long userId) {
        // 如果为超级管理员则返回admin
        if(SecurityUtils.isAdmin()){
            List<String> roleKeys = new ArrayList<>();
            roleKeys.add("admin");
            return roleKeys;
        }
        // 如果不是管理员则查询所拥有的权限
        List<String> roleKeys = roleMapper.selectRoleKeyByUserId(userId);

        return roleKeys;
    }

}
