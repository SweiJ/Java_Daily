package com.swei.ordermeal.dto;

import com.swei.ordermeal.model.Dish;
import com.swei.ordermeal.model.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-13 17:19
 */
@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
