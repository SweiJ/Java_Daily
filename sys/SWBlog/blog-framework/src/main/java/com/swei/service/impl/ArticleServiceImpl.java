package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.constants.SystemConstants;
import com.swei.dto.ArticleDto;
import com.swei.dto.ArticleListDto;
import com.swei.entity.Article;
import com.swei.entity.Category;
import com.swei.entity.Link;
import com.swei.entity.Tag;
import com.swei.mapper.ArticleMapper;
import com.swei.mapper.ArticleTagMapper;
import com.swei.mapper.TagMapper;
import com.swei.service.ArticleService;
import com.swei.service.CategoryService;
import com.swei.utils.BeanCopyUtils;
import com.swei.utils.RedisCache;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-24 12:45
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleTagMapper articleTagMapper;

    /**
     * 查询热点文章列表
     * @return
     */
    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        // 状态为已发布
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        // 按照访问量的顺序排序
        queryWrapper.orderByDesc(Article::getViewCount);
        // 最多只能查询10条
        Page<Article> page = new Page<>(1, 10);
        page(page, queryWrapper);

        List<Article> articles = page.getRecords();

//        ArrayList<HotArticleVo> articleVos = new ArrayList<>();
//        for (Article article : articles) {
//            HotArticleVo articleVo = new HotArticleVo();
//
//            BeanUtils.copyProperties(article, articleVo);
//            articleVos.add(articleVo);
//        }
        List<HotArticleVo> voList = BeanCopyUtils.copyBeanList(articles, HotArticleVo.class);
        return ResponseResult.okResult(voList);
    }

    /**
     * 查询文章列表
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        // 查询条件
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        // 所有状态为已发布
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        // 如果有分类则查询当前分类下的所有文章
        articleWrapper.eq(categoryId > 0, Article::getCategoryId, categoryId);
        // 按照置顶字段排序 降序 1为置顶
        articleWrapper.orderByDesc(Article::getIsTop);

        // 分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, articleWrapper);

        // 查询categoryName
        List<Article> articles = page.getRecords();
        // 利用流的形式将分类名称赋值给article
        articles = articles.stream()
                .map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
                .collect(Collectors.toList());

        // 利用循环的方式将分类名称赋值给article
//        for (Article article : articles) {
//            Long id = article.getCategoryId();
//            Category category = categoryService.getById(id);
//            article.setCategoryName(category.getName());
//        }

        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);
        // 封装一个页面
        PageVo pageVo = new PageVo(articleListVos, page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 根据id查询文章详情
     * @param id
     * @return
     */
    @Override
    public ResponseResult getArticleDetail(Long id) {
        // 根据id查询文章
        Article article = getById(id);
        // 从redis中获取浏览量
        Integer viewCount = redisCache.getCacheMapValue(SystemConstants.ARTICLEVIEWCOUNT, id.toString());
        article.setViewCount(viewCount.longValue());
        // 封装一个vo类
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        // 设置categoryName
        Category category = categoryService.getById(articleDetailVo.getCategoryId());
        if(category != null) {
            articleDetailVo.setCategoryName(category.getName());
        }
        // 返回结果
        return ResponseResult.okResult(articleDetailVo);
    }

    /**
     * 更新redis中博客信息浏览量
     * @param id
     * @return
     */
    @Override
    public ResponseResult updateViewCount(Long id) {
        redisCache.incrementCacheMapValue(SystemConstants.ARTICLEVIEWCOUNT, id.toString(), 1);

        return ResponseResult.okResult();
    }

    /**
     * 后台获取文章列表
     * @param pageNum
     * @param pageSize
     * @param articleListDto
     * @return
     */
    @Override
    public ResponseResult getArticleList(Integer pageNum, Integer pageSize, ArticleListDto articleListDto) {
        // 分页
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(StringUtils.hasText(articleListDto.getTitle()), Article::getTitle, articleListDto.getTitle());
        articleWrapper.eq(StringUtils.hasText(articleListDto.getSummary()), Article::getSummary, articleListDto.getSummary());

        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, articleWrapper);

        PageVo pageVo = new PageVo(page.getRecords(), page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 新增文章
     * @param articleDto
     * @return
     */
    @Override
    public ResponseResult addArticle(ArticleDto articleDto) {
        if(!StringUtils.hasText(articleDto.getTitle())) {
            throw new SystemException(HttpCodeEnum.ARTICLE_IS_NULL);
        }

        Article article = BeanCopyUtils.copyBean(articleDto, Article.class);
        article.setViewCount(0L);
        save(article);

        articleTagMapper.insertTags(article.getId(), articleDto.getTags());

        return ResponseResult.okResult();
    }

    /**
     * 逻辑删除文章
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteArticle(List<String> id) {
        articleMapper.deleteArticle(id);

        return ResponseResult.okResult();
    }

    /**
     * 获取文章信息
     * @param id
     * @return
     */
    @Override
    public ResponseResult getArticle(String id) {
        // 根据id查询文章
        Article article = getById(id);

        // 封装类  缺少标签
        ArticleDto articleDto = BeanCopyUtils.copyBean(article, ArticleDto.class);

        // 获取该文章的标签信息
        List<TagVo> tags = articleMapper.selectTagsByArticleId(id);
        List<String> tagsName = tags.stream()
                .map(tag -> tag.getName())
                .collect(Collectors.toList());

        articleDto.setTags(tagsName);

        return ResponseResult.okResult(articleDto);
    }

    /**
     * 修改文章内容
     * @param articleDto
     * @return
     */
    @Override
    @Transactional
    public ResponseResult updateArticle(ArticleDto articleDto) {
        if(!StringUtils.hasText(articleDto.getTitle())) {
            throw new SystemException(HttpCodeEnum.ARTICLE_IS_NULL);
        }

        // 更新文章
        Article article = BeanCopyUtils.copyBean(articleDto, Article.class);
        updateById(article);

        // 更新文章标签中间表
        // 删除该文章对应的标签
        articleTagMapper.deleteTag(article.getId());
        // 插入标签
        articleTagMapper.insertTags(article.getId(), articleDto.getTags());

        return ResponseResult.okResult();
    }
}
