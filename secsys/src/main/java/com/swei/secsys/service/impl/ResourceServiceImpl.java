package com.swei.secsys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.secsys.mapper.ResourceMapper;
import com.swei.secsys.pojo.Resource;
import com.swei.secsys.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-31
 * Time: 8:46
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> getResource() {
        return resourceMapper.getResource();
    }

    @Override
    public Set<Long> getResourceIdsByUserId(Integer id) {
        return resourceMapper.getResourceIdsByUserId(id);
    }
}
