package com.swei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章标签关联表(ArticleTag)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-29 15:10:55
 */
@Mapper
public interface ArticleTagMapper {
    /**
     * 为当前文章插入标签连接表
     * @param articleId
     * @param tags
     */
    void insertTags(@Param("articleId") Long articleId, @Param("tags") List<String> tags);


    void deleteTag(@Param("id") Long id);
}
