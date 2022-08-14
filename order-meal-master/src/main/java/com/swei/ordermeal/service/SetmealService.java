package com.swei.ordermeal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.ordermeal.dto.SetmealDto;
import com.swei.ordermeal.model.Setmeal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-13
 * Time: 15:09
 * @author SweiPC
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐
     * @param setmealDto
     */
    void saveWithDish(SetmealDto setmealDto);

}
