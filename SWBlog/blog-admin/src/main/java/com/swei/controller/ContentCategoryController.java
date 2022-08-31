package com.swei.controller;

import com.swei.dto.CategoryListDto;
import com.swei.entity.Category;
import com.swei.service.CategoryService;
import com.swei.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 10:13
 */
@RestController
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取分类列表信息
     * @param pageNum
     * @param pageSize
     * @param categoryListDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult getCategoryList(Integer pageNum, Integer pageSize, CategoryListDto categoryListDto) {
        return categoryService.getAdminCategoryList(pageNum, pageSize, categoryListDto);
    }

    /**
     * 新增分类
     * @param category
     * @return
     */
    @PostMapping
    public ResponseResult addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    /**
     * 逻辑删除和批量删除分类
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteCategory(@PathVariable List<String> id) {
        return categoryService.deleteCategory(id);
    }


    /**
     * 获取当前文章信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getCategory(@PathVariable String id) {
        return categoryService.getCategory(id);
    }

    /**
     * 修改分类状态
     * @param article
     * @return
     */
    @PutMapping
    public ResponseResult updateArticle(@RequestBody Category article) {
        return categoryService.updateCategory(article);
    }

    /**
     * 获取所有分类
     * @return
     */
    @GetMapping("/listAllCategory")
    public ResponseResult listAllCategory() {
        return categoryService.listAllCategory();
    }

    @GetMapping("/export")
    public ResponseResult exportCategory(HttpServletResponse response) {
        return categoryService.exportCategory(response);
    }

}
