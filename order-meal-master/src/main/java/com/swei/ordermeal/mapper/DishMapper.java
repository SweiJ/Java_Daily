package com.swei.ordermeal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.ordermeal.model.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-13
 * Time: 15:06
 * @author SweiPC
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}
