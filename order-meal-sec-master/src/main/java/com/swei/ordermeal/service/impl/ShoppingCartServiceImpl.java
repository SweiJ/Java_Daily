package com.swei.ordermeal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.ordermeal.mapper.ShoppingCartMapper;
import com.swei.ordermeal.model.ShoppingCart;
import com.swei.ordermeal.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-15 9:02
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
