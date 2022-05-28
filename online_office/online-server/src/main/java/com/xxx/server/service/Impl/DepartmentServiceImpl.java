package com.xxx.server.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.DepartmentMapper;
import com.xxx.server.pojo.Department;
import com.xxx.server.pojo.ResBean;
import com.xxx.server.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author swei
 * @since 2022-05-05
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 获取所有部门
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1);
    }

    /**
     * 添加部门
     * @param dep
     * @return
     */
    @Override
    public ResBean addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
        if(1 == dep.getResult()) {
            return ResBean.success("添加成功!", dep);
        }
        return ResBean.error("添加失败!");
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @Override
    public ResBean deleteDep(Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentMapper.deleteDep(dep);
        if(-2 == dep.getResult()) {
            return ResBean.error("该部门还有子部门, 删除失败!");
        }
        if(-1 == dep.getResult()) {
            return ResBean.error("该部门还有员工, 删除失败!");
        }
        if(1 == dep.getResult()) {
            return ResBean.success("删除成功!");
        }
        return ResBean.error("删除失败!");
    }
}
