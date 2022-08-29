package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.entity.LoginUser;
import com.swei.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2022-08-28 15:40:40
 */
public interface MenuService extends IService<Menu> {

    /**
     * 获取权限信息
     * @param userId
     * @return
     */
    List<String> selectPermsByUserId(Long userId);

    /**
     * 获取路由菜单
     * @param userId
     * @return
     */
    List<Menu> selectRouterMenuTreeByUserId(@Param("userId") Long userId);
}

