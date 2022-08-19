package com.swei.ordermeal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.ordermeal.model.Orders;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-15 11:15
 */
public interface OrderService extends IService<Orders> {

    /**
     * 提交订单
     * @param orders
     */
    void submit(Orders orders);
}
