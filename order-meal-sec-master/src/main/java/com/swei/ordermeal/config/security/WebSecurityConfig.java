package com.swei.ordermeal.config.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.swei.ordermeal.common.CustomException;
import com.swei.ordermeal.model.Employee;
import com.swei.ordermeal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.ObjectUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-18 14:27
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestAuthoricationEntryPoint restAuthoricationEntryPoint;

    @Autowired
    private EmployeeService employeeService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(getBCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/backend/api/**",
                "/backend/images/**",
                "/backend/js/**",
                "/backend/page/**",
                "/backend/plugins/**",
                "/backend/styles/**",
                "/backend/*.ico",
                "/backend/index.html",
                "/backend/**",
                "/front/**"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
//                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers("/login","/employee/login").permitAll()
                // 其他资源都要认证
                .antMatchers("/**").authenticated()
                .and()
                // 禁用缓存
                .headers()
                .cacheControl();
        // 开启表单登录

        http.formLogin()
                // 登录页
//                .loginPage("/backend/page/login/login.html")
                .loginPage("/login")
                // 登录请求路径
                .loginProcessingUrl("/employee/login");
        // 登录成功处理
//                .successHandler(new MyAuthenticationSuccessHandler())
        // 登录失败处理
//                .failureHandler(new MyAuthenticationFailureHandler());
        http.addFilterBefore(jwtAuthencationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        // 添加自定义未授权和未登陆结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthoricationEntryPoint);
//        http.csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return username -> {
            LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Employee::getName, username);
            Employee employee = employeeService.getOne(queryWrapper);
            if(ObjectUtils.isEmpty(employee)) {
                throw new CustomException("用户名密码不正确!");
            }
            employee.setRoles(employeeService.getRoles(employee.getId()));
            return employee;
        };
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthencationTokenFilter jwtAuthencationTokenFilter() {
        return new JwtAuthencationTokenFilter();
    }
}
