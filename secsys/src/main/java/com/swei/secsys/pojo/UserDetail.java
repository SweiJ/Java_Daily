package com.swei.secsys.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-01
 * Time: 14:03
 */
public class UserDetail extends User {

    private com.swei.secsys.pojo.User user;

    public UserDetail(com.swei.secsys.pojo.User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }
}
