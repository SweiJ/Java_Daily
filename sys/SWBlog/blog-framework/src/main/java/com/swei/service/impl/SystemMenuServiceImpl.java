package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.dto.MenuListDto;
import com.swei.entity.Menu;
import com.swei.mapper.MenuMapper;
import com.swei.service.SystemMenuService;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 18:11
 */
@Service
public class SystemMenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements SystemMenuService {

    /**
     * 获取菜单列表信息
     * @param menuListDto
     * @return
     */
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
     * 新增角色
     * @param menu
     * @return
     */
    @Override
    public ResponseResult addMenu(Menu menu) {
        if(StringUtils.hasText(menu.getMenuName())) {
            throw new SystemException(HttpCodeEnum.MENU_IS_NULL);
        }

        save(menu);
        return ResponseResult.okResult();
    }

    /**
     * 逻辑删除角色
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteMenu(List<String> id) {
        return null;
    }

    /**
     * 获取角色
     * @param id
     * @return
     */
    @Override
    public ResponseResult getMenu(String id) {
        Menu menu = getById(id);

        return ResponseResult.okResult(menu);
    }

    /**
     * 更新角色
     * @param menu
     * @return
     */
    @Override
    public ResponseResult updateMenu(Menu menu) {
        updateMenu(menu);

        return ResponseResult.okResult();
    }
}
