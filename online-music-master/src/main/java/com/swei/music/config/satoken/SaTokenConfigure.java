package com.swei.music.config.satoken;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-11
 * Time: 20:35
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册Sa-Token的路由拦截器
        registry.addInterceptor(new SaRouteInterceptor(
                        (req, res, handler)-> {
                            // 根据路由划分模块，不同模块不同鉴权
//                            SaRouter.match("/music/**", r -> StpUtil.checkPermission(""));
                            SaRouter.match("/lovemusic/**",r -> StpUtil.checkRole("超级管理员"));
                        }))
                .addPathPatterns("/**")
                .excludePathPatterns("/index");
    }
}
