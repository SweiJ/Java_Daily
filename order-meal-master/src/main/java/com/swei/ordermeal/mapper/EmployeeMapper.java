package com.swei.ordermeal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.ordermeal.model.Employee;
import org.apache.ibatis.annotations.Mapper;

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

}
