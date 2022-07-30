package com.swei.dao;

import com.swei.entity.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-07-22
 * Time: 19:51
 */
public interface RoleDao {
    List<Role> findAll();
}
