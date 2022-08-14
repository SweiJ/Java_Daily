package com.swei.music.service.impl;

import com.swei.music.mapper.ResourceMapper;
import com.swei.music.model.Resource;
import com.swei.music.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-10
 * Time: 20:51
 * @author SweiPC
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> getResource() {
        return resourceMapper.getResource();
    }

    @Override
    public List<Resource> getResourceByUserId(Integer id) {
        return resourceMapper.getResourceByUserId(id);
    }
}
