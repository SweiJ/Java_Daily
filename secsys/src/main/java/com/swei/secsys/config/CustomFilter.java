package com.swei.secsys.config;

import com.swei.secsys.pojo.Resource;
import com.swei.secsys.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-29
 * Time: 16:19
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private ResourceService resourceService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        HttpServletRequest request = ((FilterInvocation) o).getRequest();

        List<Resource> menus = resourceService.getResource();

        for (Resource menu : menus) {
            String[] split = menu.getPath().split(":");

            AntPathRequestMatcher ant = new AntPathRequestMatcher(split[1]);
            // 如果请求方法和请求路径都匹配上了，则代表找到了这个请求所需的权限资源
            if (request.getMethod().equals(split[0]) && ant.matches(request)) {
                // 将我们权限资源id返回
                return Collections.singletonList(new SecurityConfig(menu.getId().toString()));
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
