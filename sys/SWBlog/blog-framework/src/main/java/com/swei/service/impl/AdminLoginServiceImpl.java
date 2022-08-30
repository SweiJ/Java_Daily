package com.swei.service.impl;

import com.swei.constants.SystemConstants;
import com.swei.dto.UserDto;
import com.swei.entity.LoginUser;
import com.swei.entity.Menu;
import com.swei.entity.User;
import com.swei.service.AdminLoginService;
import com.swei.service.MenuService;
import com.swei.service.RoleService;
import com.swei.service.UserService;
import com.swei.utils.*;
import com.swei.vo.AdminUserInfoVo;
import com.swei.vo.RouterVo;
import com.swei.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-28 14:49
 */
@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Override
    public ResponseResult login(UserDto userDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDto.getUserName(), userDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        if(Objects.isNull(authenticate)) {
            throw new RuntimeException("用户或密码错误!");
        }
        // 获取userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();

        // 把用户存入redis
        String jwt = JwtUtil.createJWT(userId);
        redisCache.setCacheObject(SystemConstants.ADMINLOGIN + userId, loginUser);

        // 返回token信息
        HashMap<String, String> map = new HashMap<>();
        map.put(SystemConstants.TOKEN, jwt);
        return ResponseResult.okResult(map);
    }

    /**
     * 获取权限信息
     * @return
     */
    @Override
    public ResponseResult<AdminUserInfoVo> getInfo() {

        // 获取当前用户id
        LoginUser loginUser = SecurityUtils.getLoginUser();
        Long userId = SecurityUtils.getUserId();

        // 查询用户权限信息
        List<String> permissions = menuService.selectPermsByUserId(userId);

        // 查询用户角色信息
        List<String> roles = roleService.selectRoleKeyByUserId(userId);

        // 封装AdminUserInfoVo对象
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);

        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(permissions, roles, userInfoVo);

        return ResponseResult.okResult(adminUserInfoVo);
    }

    @Override
    public ResponseResult<RouterVo> getRouters() {
        // 获取用户id
        Long userId = SecurityUtils.getUserId();

        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);

        RouterVo routerVo = new RouterVo(menus);
        return ResponseResult.okResult(routerVo);
    }

    /**
     * 退出登录
     * @return
     */
    @Override
    public ResponseResult logout() {
        // 获取用户id
        Long userId = SecurityUtils.getUserId();

        // 删除redis中token
        redisCache.deleteObject(SystemConstants.BLOGLOGIN + userId);
        return ResponseResult.okResult();
    }
}
