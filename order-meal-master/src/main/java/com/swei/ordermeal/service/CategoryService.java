package com.swei.ordermeal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.ordermeal.model.Category;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-13
 * Time: 14:26
 * @author SweiPC
 */
public interface CategoryService extends IService<Category> {

    /**
     * 删除
     * @param ids
     */
    void delete(Long ids);
}
