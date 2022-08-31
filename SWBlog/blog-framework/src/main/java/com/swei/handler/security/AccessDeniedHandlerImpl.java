package com.swei.handler.security;

import com.alibaba.fastjson.JSON;
import com.swei.utils.ResponseResult;
import com.swei.utils.WebUtils;
import com.swei.utils.enums.HttpCodeEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
 * @data: 2022-08-25 13:09
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        ResponseResult result = ResponseResult.errorResult(HttpCodeEnum.NO_OPERATOR_AUTH);

        WebUtils.renderString(response, JSON.toJSONString(result));
    }
}
