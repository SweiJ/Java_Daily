package com.swei.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.constants.SystemConstants;
import com.swei.dto.CategoryListDto;
import com.swei.entity.Article;
import com.swei.entity.Category;
import com.swei.entity.Link;
import com.swei.mapper.CategoryMapper;
import com.swei.service.ArticleService;
import com.swei.service.CategoryService;
import com.swei.utils.BeanCopyUtils;
import com.swei.utils.ExcelUtil;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.CategoryExcelVo;
import com.swei.vo.CategoryVo;
import com.swei.vo.PageVo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-08-24 16:42:30
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Value("${excel.templatePath}")
    private String templatePath;

    /**
     * 前台获取分类列表
     * @return
     */
    @Override
    public ResponseResult getCategoryList() {
        // 查询正常状态文章 所有的分类
        // 查询文章表 状态为已发布的文章
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articleWrapper);
        
        // 查询文章的分类id, 并且去重
        Set<Long> categoryIds = articleList.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());
        // 通过id查询状态为0的分类表
        List<Category> categories = listByIds(categoryIds);
        categories = categories.stream()
                .filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());
        // 分装vo
        BeanCopyUtils.copyBeanList(categories, CategoryVo.class);

        return ResponseResult.okResult(categories);
    }

    /**
     * 后台获取文章分类
     * @param pageNum
     * @param pageSize
     * @param categoryListDto
     * @return
     */
    @Override
    public ResponseResult getAdminCategoryList(Integer pageNum, Integer pageSize, CategoryListDto categoryListDto) {
        // 分页
        LambdaQueryWrapper<Category> categoryWrapper = new LambdaQueryWrapper<>();
        categoryWrapper.like(StringUtils.hasText(categoryListDto.getName()), Category::getName, categoryListDto.getName());
        categoryWrapper.eq(StringUtils.hasText(categoryListDto.getStatus()), Category::getStatus, categoryListDto.getStatus());

        Page<Category> page = new Page<>(pageNum, pageSize);
        page(page, categoryWrapper);

        PageVo pageVo = new PageVo(page.getRecords(), page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 新增分类
     * @param category
     * @return
     */
    @Override
    public ResponseResult addCategory(Category category) {
        if(!StringUtils.hasText(category.getName())) {
            throw new SystemException(HttpCodeEnum.CATEGORY_IS_NULL);
        }

        save(category);
        return ResponseResult.okResult();
    }

    /**
     * 逻辑删除分类
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteCategory(List<String> id) {
        categoryMapper.deleteCategory(id);

        return ResponseResult.okResult();
    }

    /**
     * 获取当前分类信息
     * @param id
     * @return
     */
    @Override
    public ResponseResult getCategory(String id) {
        Category category = getById(id);

        return ResponseResult.okResult(category);
    }

    /**
     * 更新分类信息
     * @param article
     * @return
     */
    @Override
    public ResponseResult updateCategory(Category article) {
        updateById(article);

        return ResponseResult.okResult();
    }

    /**
     * 获取所有分类
     * @return
     */
    @Override
    public ResponseResult listAllCategory() {
        LambdaQueryWrapper<Category> categoryWrapper = new LambdaQueryWrapper<>();

        categoryWrapper.eq(Category::getStatus, SystemConstants.STATUS_NORMAL);
        List<Category> categories = list(categoryWrapper);

        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);
//
        return ResponseResult.okResult(categoryVos);
    }

    /**
     * 导出分类数据
     * @param response
     * @return
     */
    @Override
    public ResponseResult exportCategory(HttpServletResponse response) {

        List<Category> categories = list();
        List<CategoryExcelVo> categoryExcelVos = BeanCopyUtils.copyBeanList(categories, CategoryExcelVo.class);
        //调用工具类
        ExcelUtil.exportExcel(categoryExcelVos,"分类",CategoryExcelVo.class,response);

        return ResponseResult.okResult();
    }


}
