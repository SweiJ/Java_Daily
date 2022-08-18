package com.swei.ordermeal.config.security;

import com.swei.ordermeal.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-18 14:31
 */
@Slf4j
public class JwtAuthencationTokenFilter extends OncePerRequestFilter {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("token信息!");
        // 请求头中获取token信息
        String authheader = request.getHeader(tokenHeader);
        // 存在token
        if(null != authheader && authheader.startsWith(tokenHead)) {
            // 去除字段名称, 获取真正token
            String authToken = authheader.substring(tokenHead.length());
            // 利用token获取用户名
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            // token存在用户但未登陆
            // SecurityContextHolder.getContext().getAuthentication() 获取前端提交的用户登陆信息
            if(null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
                // 自定义数据源获取用户信息
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                // 验证token是否有效 验证token用户名和存储的用户名是否一致以及是否在有效期内, 重新设置用户对象
                if(jwtTokenUtil.validateToken(authToken, userDetails)) {
                    // 重新将用户信息封装到UsernamePasswordAuthenticationToken
                    UsernamePasswordAuthenticationToken authenticationToken = new
                            UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    // 将信息存入上下文对象
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
