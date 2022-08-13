package com.swei.music.mapper;

import com.swei.music.model.Resource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-08-10
 * Time: 20:52
 */
@Mapper
public interface ResourceMapper {
    List<Resource> getResource();

    List<Resource> getResourceByUserId(Integer id);
}
