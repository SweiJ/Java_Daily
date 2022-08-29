package com.swei.handler.security;

import com.alibaba.fastjson.JSON;
import com.swei.utils.ResponseResult;
import com.swei.utils.WebUtils;
import com.swei.utils.enums.HttpCodeEnum;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-25 13:06
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//        ResponseResult result = ResponseResult.errorResult(HttpCodeEnum.LOGIN_ERROR);

        ResponseResult result = null;

        if(e instanceof BadCredentialsException) {
            result = ResponseResult.errorResult(HttpCodeEnum.LOGIN_ERROR.getCode(), e.getMessage());
        } else if(e instanceof InsufficientAuthenticationException) {
            result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
        }
        result = ResponseResult.errorResult(HttpCodeEnum.SYSTEM_ERROR.getCode(), "认证和授权失败!");
        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
