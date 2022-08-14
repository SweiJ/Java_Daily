package com.swei.ordermeal.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.ordermeal.dto.SetmealDto;
import com.swei.ordermeal.mapper.SetmealMapper;
import com.swei.ordermeal.model.DishFlavor;
import com.swei.ordermeal.model.Setmeal;
import com.swei.ordermeal.model.SetmealDish;
import com.swei.ordermeal.service.SetmealDishService;
import com.swei.ordermeal.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * @Author: SweiPC
 * @Data: 2022-08-13
 * @Time: 15:15
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;

    /**
     *
     * @param setmealDto
     */
    @Override
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐的基本信息到套餐表setmeal
        this.save(setmealDto);

        //套餐id
        Long setmealId = setmealDto.getId();

        //套餐菜品
        List<SetmealDish> dish = setmealDto.getSetmealDishes();
        dish = dish.stream().map((item) -> {
            item.setSetmealId(setmealId);
            return item;
        }).collect(Collectors.toList());

        //保存套餐菜品数据到套餐菜品表setmeal_Dish
        setmealDishService.saveBatch(dish);
    }
}
