package com.swei.ordermeal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.ordermeal.common.CustomException;
import com.swei.ordermeal.mapper.CategoryMapper;
import com.swei.ordermeal.model.Category;
import com.swei.ordermeal.model.Dish;
import com.swei.ordermeal.model.Setmeal;
import com.swei.ordermeal.service.CategoryService;
import com.swei.ordermeal.service.DishService;
import com.swei.ordermeal.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-13
 * Time: 14:27
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 删除菜品分类
     * @param ids
     */
    @Override
    public void delete(Long ids) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();

        // 添加查询条件, 根据分类id进行查询当前菜品分类
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, ids);
        // 查询当前菜品分类下有多少关联菜品
        int count1 = dishService.count(dishLambdaQueryWrapper);

        if(count1 > 0) {
            throw new CustomException("当前分类下关联了菜品, 不能删除!");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 查询当前套餐分类
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, ids);
        // 查询当前套餐下有多少关联商品
        int count2 = setmealService.count(setmealLambdaQueryWrapper);

        if(count2 > 0) {
            throw new CustomException("当前分类下关联了套餐, 不能删除!");
        }

        // 删除分类
        super.removeById(ids);
    }
}
