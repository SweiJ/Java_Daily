package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.MenuRole;
import com.xxx.server.pojo.ResBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author swei
 * @since 2022-05-05
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色信息
     * @param rid
     * @param mids
     * @return
     */
    ResBean updateMenuRole(Integer rid, Integer[] mids);
}
