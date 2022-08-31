package com.swei.controller;

import com.swei.dto.ArticleDto;
import com.swei.dto.ArticleListDto;
import com.swei.service.ArticleService;
import com.swei.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 9:47
 */
@RestController
@RequestMapping("/content/article")
public class ContentArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取文章列表信息
     * @param pageNum
     * @param pageSize
     * @param articleListDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult getArticleList(Integer pageNum, Integer pageSize, ArticleListDto articleListDto) {
        return articleService.getArticleList(pageNum, pageSize, articleListDto);
    }

    /**
     * 新增文章
     * @param articleDto
     * @return
     */
    @PostMapping
    public ResponseResult addArticle(@RequestBody ArticleDto articleDto) {
        return articleService.addArticle(articleDto);
    }

    /**
     * 逻辑删除和批量删除文章
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteTag(@PathVariable("id") List<String> id) {
        return articleService.deleteArticle(id);
    }

    /**
     * 获取当前文章信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getArticle(@PathVariable("id") String id) {
        return articleService.getArticle(id);
    }

    /**
     * 修改文章信息
     * @param articleDto
     * @return
     */
    @PutMapping
    public ResponseResult updateArticle(@RequestBody ArticleDto articleDto) {
        return articleService.updateArticle(articleDto);
    }
}
