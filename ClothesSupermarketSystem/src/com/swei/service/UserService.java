package com.swei.service;

import com.swei.bean.User;
import com.swei.utils.BusinessException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-20
 * Time: 14:25
 */
public interface UserService {
    User register(User user) throws BusinessException;
}
