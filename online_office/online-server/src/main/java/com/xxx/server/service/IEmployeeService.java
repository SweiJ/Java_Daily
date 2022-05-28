package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.Employee;
import com.xxx.server.pojo.ResBean;
import com.xxx.server.pojo.ResPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author swei
 * @since 2022-05-05
 */
public interface IEmployeeService extends IService<Employee> {
    /**
     * 获取所有员工(员工)
     * @param currentPage
     * @param size
     * @param employeem
     * @param beginDateScope
     * @return
     */
    ResPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employeem, LocalDate[] beginDateScope);

    /**
     * 获取工号
     * @return
     */
    ResBean maxWorkID();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    ResBean addEmp(Employee employee);

    /**
     * 查询员工
     * @param id
     * @return
     */
    List<Employee> getEmployee(Integer id);
}
