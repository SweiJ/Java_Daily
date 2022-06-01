package com.swei.secsys.service;

import com.swei.secsys.pojo.Resource;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-31
 * Time: 8:45
 */
public interface ResourceService {
    List<Resource> getResource();

    Set<Long> getResourceIdsByUserId(Integer id);
}
