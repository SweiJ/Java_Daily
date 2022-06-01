package com.swei.secsys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.secsys.pojo.Resource;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-31
 * Time: 8:50
 */
public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> getResource();

    Set<Long> getResourceIdsByUserId(Integer id);
}
