package com.xxx.server.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.Menu;
import com.xxx.server.pojo.MenuRole;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author swei
 * @since 2022-05-05
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 根据用户id查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();

}
