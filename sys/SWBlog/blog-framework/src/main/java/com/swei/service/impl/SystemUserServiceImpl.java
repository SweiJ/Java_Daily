package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.dto.UserListDto;
import com.swei.entity.User;
import com.swei.mapper.UserMapper;
import com.swei.service.SystemUserService;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 17:35
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<UserMapper, User> implements SystemUserService {

    /**
     * 查询用户列表
     * @param pageNum
     * @param pageSize
     * @param userListDto
     * @return
     */
    @Override
    public ResponseResult getUserList(Integer pageNum, Integer pageSize, UserListDto userListDto) {
        // 分页
        LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<>();
        userWrapper.like(StringUtils.hasText(userListDto.getUserName()), User::getUserName, userListDto.getUserName());
        userWrapper.like(StringUtils.hasText(userListDto.getNickName()), User::getNickName, userListDto.getNickName());
        userWrapper.eq(StringUtils.hasText(userListDto.getStatus()), User::getStatus, userListDto.getStatus());

        Page<User> page = new Page<>(pageNum, pageSize);

        page(page, userWrapper);

        PageVo pageVo = new PageVo(page.getRecords(), page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public ResponseResult addUser(User user) {
        if(StringUtils.hasText(user.getUserName())) {
            throw new SystemException(HttpCodeEnum.USER_IS_NULL);
        }

        save(user);
        return ResponseResult.okResult();
    }

    /**
     * 逻辑删除用户
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteUser(List<String> id) {
        return ResponseResult.okResult();
    }

    /**
     * 获取当前用户
     * @param id
     * @return
     */
    @Override
    public ResponseResult getUser(String id) {
        User user = getById(id);

        return ResponseResult.okResult(user);
    }

    /**
     * 更新当前用户
     * @param user
     * @return
     */
    @Override
    public ResponseResult updateUser(User user) {
        updateUser(user);

        return ResponseResult.okResult();
    }


}
