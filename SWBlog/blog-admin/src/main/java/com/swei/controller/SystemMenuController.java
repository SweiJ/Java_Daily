package com.swei.controller;

import com.swei.dto.MenuListDto;
import com.swei.entity.Menu;
import com.swei.service.SystemMenuService;
import com.swei.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 18:08
 */
@RestController
@RequestMapping("/system/menu")
public class SystemMenuController {

    @Autowired
    private SystemMenuService systemMenuService;

    /**
     * 获取菜单列表信息
     * @param menuListDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult getMenuList(MenuListDto menuListDto) {
        return systemMenuService.getMenuList(menuListDto);
    }

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    @PostMapping
    public ResponseResult addMenu(@RequestBody Menu menu) {
        return systemMenuService.addMenu(menu);
    }

    /**
     * 逻辑删除和批量删除菜单
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteMenu(@PathVariable List<String> id) {
        return systemMenuService.deleteMenu(id);
    }

    /**
     * 获取当前菜单信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getMenu(@PathVariable String id) {
        return systemMenuService.getMenu(id);
    }

    /**
     * 修改菜单信息
     * @param menu
     * @return
     */
    @PutMapping
    public ResponseResult updateMenu(@RequestBody Menu menu) {
        return systemMenuService.updateMenu(menu);
    }

    /**
     * 获取资源下拉菜单 所有资源信息
     * @return
     */
    @GetMapping("/treeselect")
    public ResponseResult getSelectedMenu() {
        return systemMenuService.getSelectedMenu();
    }

    /**
     * 获取某个角色所对应的资源
     * @return
     */
    @GetMapping("/roleMenuTreeselect/{id}")
    public ResponseResult getRoleMenuTreeselect(@PathVariable String id) {
        return systemMenuService.getRoleMenuTreeselect(id);
    }
}
