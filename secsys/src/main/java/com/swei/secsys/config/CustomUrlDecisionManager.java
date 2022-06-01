package com.swei.secsys.config;

import io.jsonwebtoken.lang.Collections;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-29
 * Time: 16:19
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {


    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if(Collections.isEmpty(collection)) {
            return;
        }
        for (ConfigAttribute configAttribute : collection) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if(Objects.equals(authority.getAuthority(), configAttribute.getAttribute())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足, 请联系管理员!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}