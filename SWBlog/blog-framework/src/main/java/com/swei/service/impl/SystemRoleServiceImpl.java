package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.constants.SystemConstants;
import com.swei.dto.RoleListDto;
import com.swei.entity.Role;
import com.swei.mapper.RoleMapper;
import com.swei.mapper.RoleMenuMapper;
import com.swei.mapper.UserRoleMapper;
import com.swei.service.SystemRoleService;
import com.swei.utils.BeanCopyUtils;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.PageVo;
import com.swei.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

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
        if(!StringUtils.hasText(role.getRoleName())) {
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

        // 查询是否还存在用户是这个角色 如果有则返回错误
//        List<Long> ids = id.stream().map(Long::valueOf).collect(Collectors.toList());
        int count = userRoleMapper.selectUserRoleByRoleIds(id);
        if(count > 0) {
            throw new SystemException(HttpCodeEnum.ROLE_BIND_USER);
        }

        // 没有则删除
        roleMapper.deleteRoleByIds(id);

        return ResponseResult.okResult();
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
        // 修改角色
        updateById(role);

        // 删除当前角色拥有的资源关联信息
        roleMenuMapper.deleteRoleMenuByRoleId(role.getId());
        // 修改角色资源关联表
        roleMenuMapper.insertRoleMenu(role.getId(), role.getMenuIds());

        return ResponseResult.okResult();
    }

    /**
     * 获取角色名称列表
     * @return
     */
    @Override
    public ResponseResult listAllRole() {
        LambdaQueryWrapper<Role> roleWrapper = new LambdaQueryWrapper<>();
        // 状态正常的角色
        roleWrapper.eq(Role::getStatus, SystemConstants.STATUS_NORMAL);

        // 所有角色
        List<Role> roles = list(roleWrapper);
        // 封装
        List<RoleVo> roleList = BeanCopyUtils.copyBeanList(roles, RoleVo.class);
        return ResponseResult.okResult(roleList);
    }

}
