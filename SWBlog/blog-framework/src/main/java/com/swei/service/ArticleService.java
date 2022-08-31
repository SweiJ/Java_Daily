package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.dto.ArticleDto;
import com.swei.dto.ArticleListDto;
import com.swei.entity.Article;
import com.swei.utils.ResponseResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-24 12:43
 */
public interface ArticleService extends IService<Article> {

    /**
     * 查询热点文章
     * @return
     */
    ResponseResult hotArticleList();

    /**
     * 查询文章列表
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    /**
     * 根据id查询文章详情
     * @param id
     * @return
     */
    ResponseResult getArticleDetail(Long id);

    /**
     * 更新redis中博客信息浏览量
     * @param id
     * @return
     */
    ResponseResult updateViewCount(Long id);

    /**
     * 后台获取文章列表
     * @param pageNum
     * @param pageSize
     * @param articleListDto
     * @return
     */
    ResponseResult getArticleList(Integer pageNum, Integer pageSize, ArticleListDto articleListDto);

    /**
     * 新增文章
     * @param articleDto
     * @return
     */
    ResponseResult addArticle(ArticleDto articleDto);

    /**
     * 逻辑删除文章
     * @param id
     * @return
     */
    ResponseResult deleteArticle(List<String> id);

    /**
     * 获取文章信息
     * @param id
     * @return
     */
    ResponseResult getArticle(String id);

    /**
     * 修改文章信息
     * @param articleDto
     * @return
     */
    ResponseResult updateArticle(ArticleDto articleDto);
}
