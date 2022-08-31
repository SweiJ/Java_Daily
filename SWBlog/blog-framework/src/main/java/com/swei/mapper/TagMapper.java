package com.swei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标签(Tag)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-28 14:01:47
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 逻辑删除标签
     * @param id
     */
    void deleteTag(@Param("ids") List<String> id);
}
