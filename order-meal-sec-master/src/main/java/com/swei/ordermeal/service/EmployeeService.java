package com.swei.ordermeal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.ordermeal.model.Employee;
import com.swei.ordermeal.model.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-12
 * Time: 22:48
 * @author SweiPC
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 获取账户角色
     * @param id
     * @return
     */
    List<Role> getRoles(Long id);
}
