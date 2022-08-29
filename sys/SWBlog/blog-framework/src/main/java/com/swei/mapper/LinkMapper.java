package com.swei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.entity.Link;
import com.swei.utils.ResponseResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 友链(Link)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-25 08:52:40
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

    /**
     * 逻辑删除和批量删除友联
     * @param id
     */
    void deleteLink(@Param("ids") List<String> id);
}
