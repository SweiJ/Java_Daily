package com.swei.utils;

import com.swei.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-27 13:45
 */
public class SecurityUtils {
    /**
     * 获取用户
     * @return
     */
    public static LoginUser getLoginUser() {
        return (LoginUser) getAuthentication().getPrincipal();
    }

    /**
     * 获取Authentication
     * @return
     */
    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 判断是否为管理员
     * @return
     */
    public static Boolean isAdmin() {
        Long id = getUserId();
        return id != null && id.equals(1L);
    }

    /**
     * 获取用户id
     * @return
     */
    public static Long getUserId() {
        return getLoginUser().getUser().getId();
    }
}
