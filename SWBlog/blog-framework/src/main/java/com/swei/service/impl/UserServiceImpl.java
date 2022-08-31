package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.entity.LoginUser;
import com.swei.entity.User;
import com.swei.mapper.UserMapper;
import com.swei.service.UserService;
import com.swei.utils.BeanCopyUtils;
import com.swei.utils.ResponseResult;
import com.swei.utils.SecurityUtils;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-25 16:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 查询个人信息
     * @return
     */
    @Override
    public ResponseResult userInfo() {
        // 获取用户id查询用户
        Long userId = SecurityUtils.getUserId();

        User user = getById(userId);

        // 封装成userInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        return ResponseResult.okResult(userInfoVo);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public ResponseResult updateUserInfo(User user) {
        updateById(user);
        return ResponseResult.okResult();
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public ResponseResult register(User user) {
        // 对数据进行非空判断
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(HttpCodeEnum.USERNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(HttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getEmail())){
            throw new SystemException(HttpCodeEnum.EMAIL_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(HttpCodeEnum.NICKNAME_NOT_NULL);
        }

        // 数据是否存在
        if(userNameExist(user.getUserName())){
            throw new SystemException(HttpCodeEnum.USERNAME_EXIST);
        }
        if(nickNameExist(user.getNickName())){
            throw new SystemException(HttpCodeEnum.NICKNAME_EXIST);
        }

        // 对密码进行加密处理
        String encode = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encode);

        // 存储用户
        save(user);
        return ResponseResult.okResult();
    }

    private boolean nickNameExist(String nickName) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getNickName, nickName);
        return count(queryWrapper) > 0;
    }

    private boolean userNameExist(String userName) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, userName);
        return count(queryWrapper) > 0;
    }

}
