package com.swei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-28 15:40:40
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询用户所拥有的权限
     * @param userId
     */
    List<String> selectPermsByUserId(@Param("userId") Long userId);

    /**
     * 获取路由信息
     * @param userId
     * @return
     */
    List<Menu> selectRouterMenuTreeByUserId(Long userId);

    /**
     * 获取管理员所有路由信息
     * @return
     */
    List<Menu> selectAllRouterMenuTree();

}
