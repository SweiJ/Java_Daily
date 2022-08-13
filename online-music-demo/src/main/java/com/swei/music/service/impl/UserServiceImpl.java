package com.swei.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.music.mapper.RoleMapper;
import com.swei.music.mapper.UserMapper;
import com.swei.music.model.MyUserDetails;
import com.swei.music.model.Role;
import com.swei.music.model.User;
import com.swei.music.service.UserService;
import com.swei.music.util.Constant;
import com.swei.music.util.JwtTokenUtil;
import com.swei.music.util.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-06
 * Time: 20:23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


//    public Res<User> getUserByName1(String username, String password, HttpServletRequest request) {
//        User userLogin = new User();
//        userLogin.setUsername(username);
//        userLogin.setPassword(password);
//
//        User user = userMapper.getUserByName(userLogin);
//        if(user != null) {
//            request.getSession().setAttribute(Constant.USERINFO_LOGIN_KEY, user);
//            System.out.println("登录成功!");
//            return new Res<>(0, "登录成功!", userLogin);
//        } else {
//            System.out.println("登录失败");
//            return new Res<>(-1, "登录失败!", null);
//        }
//    }

    @Override
    public List<Role> getRoles(Integer id) {
        return roleMapper.getRoles(id);
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @param password
     * @param request
     * @return
     */
    @Override
    public Res<Map<String, String>> login(String username, String password, HttpServletRequest request) {

        UserDetails userDetails = loadUserByUsername(username);
        if(null == userDetails || !bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
            return  new Res<>(-1, "用户名或密码错误!", null);
        }
        if(!userDetails.isEnabled()) {
            return new Res<>(-1, "账号被禁用,请联系管理员!", null);
        }
        // 更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(userDetails,
                null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 创建一个token
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return new Res<>(0, "登录成功!", tokenMap);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByName(username);
        if(ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("用户名密码不正确!");
        }
        List<Role> roles = getRoles(user.getId());
        Set<SimpleGrantedAuthority> authorities =  new HashSet<>();
        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new MyUserDetails(user, authorities);
    }
}
