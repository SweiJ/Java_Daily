package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.dto.MenuListDto;
import com.swei.entity.Menu;
import com.swei.mapper.MenuMapper;
import com.swei.service.SystemMenuService;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 18:11
 */
@Service
public class SystemMenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements SystemMenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 获取菜单列表信息
     * @param menuListDto
     * @return
    .     */
    @Override
    public ResponseResult getMenuList(MenuListDto menuListDto) {
        // 分页
        LambdaQueryWrapper<Menu> menuWrapper = new LambdaQueryWrapper<>();
        menuWrapper.like(StringUtils.hasText(menuListDto.getMenuName()), Menu::getMenuName, menuListDto.getMenuName());
        menuWrapper.eq(StringUtils.hasText(menuListDto.getStatus()), Menu::getStatus, menuListDto.getStatus());

        List<Menu> menus = list(menuWrapper);
        return ResponseResult.okResult(menus);
    }

    /**
     * 新增菜单
     * @param menu
     * @return
     */
    @Override
    public ResponseResult addMenu(Menu menu) {
        if(!StringUtils.hasText(menu.getMenuName())) {
            throw new SystemException(HttpCodeEnum.MENU_IS_NULL);
        }

        save(menu);
        return ResponseResult.okResult();
    }

    /**
     * 逻辑删除菜单
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteMenu(List<String> id) {
        // todo 删除资源信息
        return null;
    }

    /**
     * 获取菜单
     * @param id
     * @return
     */
    @Override
    public ResponseResult getMenu(String id) {
        Menu menu = getById(id);

        return ResponseResult.okResult(menu);
    }

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    @Override
    public ResponseResult updateMenu(Menu menu) {
        updateMenu(menu);

        return ResponseResult.okResult();
    }

    /**
     * 获取资源下拉菜单
     * @return
     */
    @Override
    public ResponseResult getSelectedMenu() {
        // 获取所有资源列表
        List<Menu> menuList = list();

        // 返回前端所需要的对象
        List<MenuVo> menuVos = builderMenuVoTree(menuList, 0L);

        return ResponseResult.okResult(menuVos);
    }

    /**
     * 获取某个角色所对应的资源
     * @return
     */
    @Override
    public ResponseResult getRoleMenuTreeselect(String id) {
        // 获取到该角色所有的资源
        List<Menu> menus = menuMapper.getMenusByRoleId(id);

        MenuVo menuVos = new MenuVo();
        menuVos.setMenus(builderMenuVoTree(menus, menus.get(0).getParentId()));

        return ResponseResult.okResult(menuVos);
    }

    private List<MenuVo> builderMenuVoTree(List<Menu> menus, Long parentId) {
        return menus.stream()
                // 找出最开始的根节点
                .filter(menu -> menu.getParentId().equals(parentId))
                // 将该节点的有效值赋值给前端需要数据的Vo对象
                .map(menu -> {
                    MenuVo menuVo = new MenuVo();
                    menuVo.setId(menu.getId());
                    menuVo.setLabel(menu.getMenuName());
                    menuVo.setChildren(getChildren(menu, menus));
                    return menuVo;
                }).collect(Collectors.toList());
    }

    private List<MenuVo> getChildren(Menu menu, List<Menu> menus) {
        return menus.stream()
                // 找出最开始的根节点
                .filter(m -> m.getParentId().equals(menu.getId()))
                // 设置子结点
                .map(m -> {
                    MenuVo menuVo = new MenuVo();
                    menuVo.setId(m.getId());
                    menuVo.setLabel(m.getMenuName());
                    menuVo.setChildren(getChildren(m, menus));
                    return menuVo;
                }).collect(Collectors.toList());
    }
}
