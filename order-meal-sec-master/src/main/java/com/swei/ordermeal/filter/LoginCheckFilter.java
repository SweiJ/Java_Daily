//package com.swei.ordermeal.filter;
//
//import com.alibaba.fastjson.JSON;
//import com.swei.ordermeal.common.BaseContext;
//import com.swei.ordermeal.common.R;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.AntPathMatcher;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// * User: SweiPC
// * Date: 2022-08-13
// * Time: 8:27
// * @author SweiPC
// */
//@Slf4j
//@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
//public class LoginCheckFilter implements Filter {
//
//    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        log.info("拦截到请求: {}", request.getRequestURI());
//
//
//        String requestURI = request.getRequestURI();
//
//        String[] urls = new String[] {
//                "/employee/login",
//                "/employee/logout",
//                "/backend/**",
//                "/front/**",
//                "/user/sendMsg",
//                "/user/login"
//        };
//
//        boolean check = check(requestURI, urls);
//
//        if(check) {
//            log.info("本次请求{}不需要处理", requestURI);
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        // 客户端登录状态验证
//        if(request.getSession().getAttribute("employee") != null) {
//            log.info("用户已登录, 用户id为 {}", request.getSession().getAttribute("employee"));
//
//            Long empId = (Long) request.getSession().getAttribute("employee");
//            BaseContext.setCurrentId(empId);
//
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        // 移动端登录状态验证
//        if(request.getSession().getAttribute("user") != null) {
//            log.info("用户已登录, 用户id为 {}", request.getSession().getAttribute("user"));
//
//            Long empId = (Long) request.getSession().getAttribute("user");
//            BaseContext.setCurrentId(empId);
//
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        log.info("用户未登录");
//        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
//        return;
//    }
//
//    public boolean check(String requestURI, String[] urls) {
//        for (String url : urls) {
//            if (PATH_MATCHER.match(url, requestURI)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//}
