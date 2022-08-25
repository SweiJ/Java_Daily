package com.swei.ordermeal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.ordermeal.model.Employee;
import com.swei.ordermeal.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-12
 * Time: 22:45
 * @author SweiPC
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 获取账户角色信息
     * @param id
     * @return
     */
    List<Role> getRoles(Long id);
}
