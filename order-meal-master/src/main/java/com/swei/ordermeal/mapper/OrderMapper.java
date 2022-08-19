package com.swei.ordermeal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.swei.ordermeal.model.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-15 11:16
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
