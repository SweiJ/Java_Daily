package com.xxx.server.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.MenuRoleMapper;
import com.xxx.server.pojo.MenuRole;
import com.xxx.server.pojo.ResBean;
import com.xxx.server.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author swei
 * @since 2022-05-05
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    /**
     * 更新角色信息
     * @param rid
     * @param mids
     * @return
     */
    @Override
    @Transactional
    public ResBean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid", rid));
        if(null == mids || 0 == mids.length) {
            return ResBean.success("更新成功!");
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        if(result == mids.length) {
            return ResBean.success("更新成功!");
        }
        return ResBean.error("更新失败!");
    }
}
