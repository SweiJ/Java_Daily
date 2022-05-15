package com.swei.summitexam.service;

import com.swei.summitexam.model.DataMessage;
import com.swei.summitexam.model.PaperUser;
import com.swei.summitexam.model.UserParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 10:57
 */
public interface UserService {
    DataMessage adduser(PaperUser paperuser);

    DataMessage login(PaperUser paperuser, HttpSession session);

//    Map<String, Object> updatapwd(String userName, String oldpwd, String newpwd);
    DataMessage updatapwd(UserParam userParam);

    DataMessage layout(HttpServletRequest request);
}
