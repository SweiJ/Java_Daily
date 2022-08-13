package com.swei.ordermeal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.ordermeal.mapper.EmployeeMapper;
import com.swei.ordermeal.model.Employee;
import com.swei.ordermeal.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-12
 * Time: 22:48
 * @author SweiPC
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
