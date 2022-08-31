package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.dto.MenuListDto;
import com.swei.entity.Menu;
import com.swei.utils.ResponseResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 18:11
 */
public interface SystemMenuService extends IService<Menu> {

    /**
     * 获取菜单列表
     * @param menuListDto
     * @return
     */
    ResponseResult getMenuList(MenuListDto menuListDto);

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    ResponseResult addMenu(Menu menu);

    /**
     * 逻辑删除菜单
     * @param id
     * @return
     */
    ResponseResult deleteMenu(List<String> id);

    /**
     * 获取菜单
     * @param id
     * @return
     */
    ResponseResult getMenu(String id);

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    ResponseResult updateMenu(Menu menu);

    /**
     * 获取资源下拉菜单 所有资源
     * @return
     */
    ResponseResult getSelectedMenu();

    /**
     * 获取某个角色所对应的资源
     * @return
     */
    ResponseResult getRoleMenuTreeselect(String id);
}
