package com.swei.music.service;

import com.swei.music.model.Resource;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-10
 * Time: 20:50
 * @author SweiPC
 */
public interface ResourceService {
    List<Resource> getResource();

    List<Resource> getResourceByUserId(Integer id);
}
