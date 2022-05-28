package com.xxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxx.server.pojo.Department;
import com.xxx.server.pojo.ResBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author swei
 * @since 2022-05-05
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 添加部门
     * @param dep
     * @return
     */
    ResBean addDep(Department dep);

    /**
     * 删除部门
     * @param id
     * @return
     */
    ResBean deleteDep(Integer id);
}
