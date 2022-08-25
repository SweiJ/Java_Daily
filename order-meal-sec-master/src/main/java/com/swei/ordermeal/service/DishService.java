package com.swei.ordermeal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.ordermeal.common.R;
import com.swei.ordermeal.dto.DishDto;
import com.swei.ordermeal.model.Dish;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-13
 * Time: 15:10
 */
public interface DishService extends IService<Dish> {
    /**
     * 新增菜品, 同时插入菜品对应的口味数据, 需要操作两张表, dish和dish_flavor
     * @param dishDto
     */
    void saveWithFlavor(DishDto dishDto);

    /**
     * 根据id查询菜品信息和对应的口味信息
     * @param id
     * @return
     */
    DishDto getByIdWithFlavor(Long id);

    /**
     * 修改菜品信息和对应的口味信息
     * @param dishDto
     */
    void updateWithFlavor(DishDto dishDto);

    /**
     * 根据id删除菜品及对应的口味信息
     * @param ids
     */
    void deleteDishById(List<Long> ids);

    /**
     * 修改状态信息
     * @param status
     * @param ids
     */
    void updateSalesStatus(String status, List<Long> ids);

    /**
     * 查询套餐内菜品列表
     * @param dish
     * @return
     */
    R<List<DishDto>> getCategorylist(Dish dish);
}
