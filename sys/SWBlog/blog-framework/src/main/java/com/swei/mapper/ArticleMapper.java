package com.swei.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swei.entity.Article;
import com.swei.entity.Tag;
import com.swei.vo.TagVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-24 12:42
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 逻辑删除文章
     * @param id
     */
    void deleteArticle(@Param("ids") List<String> id);

    /**
     * 获取文章所有标签
     * @param id
     * @return
     */
    List<TagVo> selectTagsByArticleId(@Param("id") String id);
}
