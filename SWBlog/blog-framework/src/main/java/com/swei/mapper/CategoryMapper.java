package com.swei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 分类表(Category)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-24 16:42:21
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 逻辑删除分类
     * @param id
     */
    void deleteCategory(@Param("ids") List<String> id);
}
