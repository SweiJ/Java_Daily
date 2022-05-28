package com.xxx.server.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxx.server.mapper.EmployeeEcMapper;
import com.xxx.server.mapper.EmployeeMapper;
import com.xxx.server.pojo.Employee;
import com.xxx.server.pojo.ResBean;
import com.xxx.server.pojo.ResPageBean;
import com.xxx.server.service.IEmployeeService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author swei
 * @since 2022-05-05
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 获取所有员工(员工)
     * @param currentPage
     * @param size
     * @param employeem
     * @param beginDateScope
     * @return
     */
    @Override
    public ResPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employeem, LocalDate[] beginDateScope) {
        Page<Employee> page = new Page<>(currentPage,size);
        IPage<Employee> employeeByPage = employeeMapper.getEmployeeByPage(page, employeem, beginDateScope);
        ResPageBean resPageBean = new ResPageBean(employeeByPage.getTotal(), employeeByPage.getRecords());
        return resPageBean;
    }

    /**
     * 获取工号
     * @return
     */
    @Override
    public ResBean maxWorkID() {
        List<Map<String, Object>> maps = employeeMapper.selectMaps(new QueryWrapper<Employee>().select("max(workID)"));
        return ResBean.success(null, String.format("08d",Integer.parseInt(maps.get(0).get("max(workID)").toString()) + 1));
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @Override
    public ResBean addEmp(Employee employee) {
        LocalDate beginContract = employee.getBeginContract();
        LocalDate endContract = employee.getEndContract();
        long days = beginContract.until(endContract, ChronoUnit.DAYS);
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(days/365.00)));
        if(1 == employeeMapper.insert(employee)) {
            Employee emp = employeeMapper.getEmployee(employee.getId()).get(0);
            rabbitTemplate.convertAndSend("mail.welcome", emp);

            return ResBean.success("添加成功!");
        }
        return ResBean.error("添加失败!");
    }

    /**
     * 查询员工
     * @param id
     * @return
     */
    @Override
    public List<Employee> getEmployee(Integer id) {
        return employeeMapper.getEmployee(id);
    }
}
