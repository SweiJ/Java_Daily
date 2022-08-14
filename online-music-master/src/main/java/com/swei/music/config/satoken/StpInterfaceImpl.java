package com.swei.music.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import com.swei.music.mapper.ResourceMapper;
import com.swei.music.mapper.RoleMapper;
import com.swei.music.mapper.UserMapper;
import com.swei.music.model.Resource;
import com.swei.music.model.Role;
import com.swei.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: 实现satoken权限、角色信息注入
 * User: SweiPC
 * Date: 2022-08-11
 * Time: 20:31
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> list = new ArrayList<>();
        List<Resource> resource = resourceMapper.getResourceByUserId(Integer.valueOf(loginId.toString()));

        for (Resource resource1 : resource) {
            list.add(resource1.getName());
        }
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<Role> roles = roleMapper.getRoles(Integer.valueOf(loginId.toString()));
        List<String> ret = new ArrayList<>();
        for (Role role : roles) {
            ret.add(role.getName());
        }
        return ret;
    }
}
