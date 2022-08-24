package com.swei.ordermeal.dto;

import com.swei.ordermeal.model.Setmeal;
import com.swei.ordermeal.model.SetmealDish;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-14 8:15
 */
@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}

