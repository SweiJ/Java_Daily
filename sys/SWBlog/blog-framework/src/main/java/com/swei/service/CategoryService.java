package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.dto.CategoryListDto;
import com.swei.entity.Category;
import com.swei.utils.ResponseResult;

import java.util.List;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-08-24 16:42:27
 */
public interface CategoryService extends IService<Category> {

    /**
     * 查询文章分类
     * @return
     */
    ResponseResult getCategoryList();

    /**
     * 后台获取文章分类
     * @param pageNum
     * @param pageSize
     * @param categoryListDto
     * @return
     */
    ResponseResult getAdminCategoryList(Integer pageNum, Integer pageSize, CategoryListDto categoryListDto);

    /**
     * 新增分类
     * @param category
     * @return
     */
    ResponseResult addCategory(Category category);

    /**
     * 逻辑删除分类
     * @param id
     * @return
     */
    ResponseResult deleteCategory(List<String> id);

    /**
     * 获取当前分类信息
     * @param id
     * @return
     */
    ResponseResult getCategory(String id);

    /**
     * 更新分类信息
     * @param article
     * @return
     */
    ResponseResult updateCategory(Category article);

    /**
     * 获取所有的分类
     * @return
     */
    ResponseResult listAllCategory();
}

