package com.swei.ordermeal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.ordermeal.mapper.OrderDetailMapper;
import com.swei.ordermeal.mapper.OrderMapper;
import com.swei.ordermeal.model.OrderDetail;
import com.swei.ordermeal.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-15 11:18
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
