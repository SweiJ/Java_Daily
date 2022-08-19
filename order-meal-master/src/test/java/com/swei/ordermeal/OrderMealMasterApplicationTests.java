package com.swei.ordermeal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.swei.ordermeal.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderMealMasterApplicationTests {

    @Test
    void contextLoads() {
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();

        Employee employee = new Employee();
        employee.setName("");
    }

}
