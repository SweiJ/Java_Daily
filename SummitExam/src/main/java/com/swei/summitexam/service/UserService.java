package com.swei.summitexam.service;

import com.swei.summitexam.model.Paperuser;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 10:57
 */
public interface UserService {
    Map<String, Object> adduser(Paperuser paperuser);

    Map<String, Object> login(Paperuser paperuser, HttpSession session);

    Map<String, Object> updatapwd(String userName, String oldpwd, String newpwd);

    Map<String, Object> layout(HttpServletRequest request);
}
