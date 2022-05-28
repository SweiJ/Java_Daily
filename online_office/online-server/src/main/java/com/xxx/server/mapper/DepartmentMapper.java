package com.xxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxx.server.pojo.Department;
import com.xxx.server.pojo.ResBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author swei
 * @since 2022-05-05
 */
//@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加部门
     * @param dep
     * @return
     */
    void addDep(Department dep);

    /**
     * 删除部门
     * @param dep
     * @return
     */
    void deleteDep(Department dep);
}
