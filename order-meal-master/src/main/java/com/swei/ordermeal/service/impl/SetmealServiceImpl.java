package com.swei.ordermeal.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.ordermeal.common.CustomException;
import com.swei.ordermeal.dto.SetmealDto;
import com.swei.ordermeal.mapper.SetmealMapper;
import com.swei.ordermeal.model.Dish;
import com.swei.ordermeal.model.DishFlavor;
import com.swei.ordermeal.model.Setmeal;
import com.swei.ordermeal.model.SetmealDish;
import com.swei.ordermeal.service.DishService;
import com.swei.ordermeal.service.SetmealDishService;
import com.swei.ordermeal.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
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

    @Autowired
    private DishService dishService;

    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
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
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item) -> {
            item.setSetmealId(setmealId);
            return item;
        }).collect(Collectors.toList());

        //保存套餐菜品数据到套餐菜品表setmeal_Dish
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 单个或者批量删除套餐
     * @param ids
     */
    @Override
    @Transactional
    public void deleteSetmealByIds(List<Long> ids) {
        //select count(*) from setmeal where id in (1,2,3) and status = 1
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 查询在里面的id
        setmealLambdaQueryWrapper.in(Setmeal::getId, ids);
        setmealLambdaQueryWrapper.eq(Setmeal::getStatus, 1);

        int count = this.count(setmealLambdaQueryWrapper);

        if(count > 0) {
            throw new CustomException("套餐正在售卖中, 不能删除!");
        }
        this.removeByIds(ids);

        // 删除关系表中的数据
        // delete from setmeal_dish where setmeal_id in (1,2,3)
        LambdaQueryWrapper<SetmealDish> setmealDishambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealDishambdaQueryWrapper.in(SetmealDish::getSetmealId, ids);

        setmealDishService.remove(setmealDishambdaQueryWrapper);
    }


}
