package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.constants.SystemConstants;
import com.swei.entity.Menu;
import com.swei.mapper.MenuMapper;
import com.swei.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.swei.service.MenuService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单权限表(Menu)表服务实现类
 *
 * @author makejava
 * @since 2022-08-28 15:40:40
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取权限信息
     * @param userId
     * @return
     */
    @Override
    public List<String> selectPermsByUserId(Long userId) {
        // 如果为超级管理员则返回所有C和F的权限
        if(SecurityUtils.isAdmin()) {
            LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
            wrapper.in(Menu::getMenuType, SystemConstants.MENU, SystemConstants.BUTTON);
            wrapper.eq(Menu::getStatus, SystemConstants.STATUS_NORMAL);

            List<Menu> menuList = list(wrapper);
            List<String> perms = menuList.stream()
                    .map(Menu::getPerms).collect(Collectors.toList());
            return perms;
        }
        // 如果不是管理员则查询所拥有的权限
        List<String> perms = menuMapper.selectPermsByUserId(userId);

        return perms;
    }

    @Override
    public List<Menu> selectRouterMenuTreeByUserId(Long userId) {
        // 判断是否为管理员
        List<Menu> menus = null;
        if(SecurityUtils.isAdmin()) {
            menus = menuMapper.selectAllRouterMenuTree();
        } else {
            menus = menuMapper.selectRouterMenuTreeByUserId(userId);
        }

        // 构建一个menuTree
        List<Menu> menuTree = builderMenuTree(menus, 0L);

        return menuTree;
    }

    private List<Menu> builderMenuTree(List<Menu> menus, Long parentId) {
        List<Menu> menuTree = menus.stream()
                .filter(menu -> menu.getParentId().equals(parentId))
                .map(menu -> menu.setChildren(getChildren(menu, menus)))
                .collect(Collectors.toList());
        return menuTree;
    }

    private List<Menu> getChildren(Menu menu, List<Menu> menus) {
        List<Menu> children = menus.stream()
                .filter(m -> m.getParentId().equals(menu.getId()))
                .map(m -> m.setChildren(getChildren(m, menus)))
                .collect(Collectors.toList());
        return children;
    }
}
