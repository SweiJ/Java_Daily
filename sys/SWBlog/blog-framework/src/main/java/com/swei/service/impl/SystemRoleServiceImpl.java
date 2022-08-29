package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.dto.RoleListDto;
import com.swei.entity.Role;
import com.swei.entity.User;
import com.swei.mapper.RoleMapper;
import com.swei.service.SystemRoleService;
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
 * @data: 2022-08-29 17:59
 */
@Service
public class SystemRoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements SystemRoleService {

    /**
     * 获取角色列表
     * @param pageNum
     * @param pageSize
     * @param roleListDto
     * @return
     */
    @Override
    public ResponseResult getRoleList(Integer pageNum, Integer pageSize, RoleListDto roleListDto) {
        // 分页
        LambdaQueryWrapper<Role> roleWrapper = new LambdaQueryWrapper<>();
        roleWrapper.like(StringUtils.hasText(roleListDto.getRoleName()), Role::getRoleName, roleListDto.getRoleName());
        roleWrapper.eq(StringUtils.hasText(roleListDto.getStatus()), Role::getStatus, roleListDto.getStatus());

        Page<Role> page = new Page<>(pageNum, pageSize);

        page(page, roleWrapper);

        PageVo pageVo = new PageVo(page.getRecords(), page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 新增角色
     * @param role
     * @return
     */
    @Override
    public ResponseResult addRole(Role role) {
        if(StringUtils.hasText(role.getRoleName())) {
            throw new SystemException(HttpCodeEnum.ROLE_IS_NULL);
        }

        save(role);
        return ResponseResult.okResult();
    }

    /**
     * 逻辑删除角色
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteRole(List<String> id) {
        return null;
    }

    /**
     * 获取角色
     * @param id
     * @return
     */
    @Override
    public ResponseResult getRole(String id) {
        Role role = getById(id);

        return ResponseResult.okResult(role);
    }

    /**
     * 更新角色
     * @param role
     * @return
     */
    @Override
    public ResponseResult updateRole(Role role) {
        updateRole(role);

        return ResponseResult.okResult();
    }


}
