package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.constants.SystemConstants;
import com.swei.dto.TagListDto;
import com.swei.entity.Category;
import com.swei.entity.Tag;
import com.swei.mapper.TagMapper;
import com.swei.service.TagService;
import com.swei.utils.BeanCopyUtils;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.CategoryVo;
import com.swei.vo.PageVo;
import com.swei.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 标签(Tag)表服务实现类
 *
 * @author makejava
 * @since 2022-08-28 14:00:21
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    /**
     * 返回标签列表
     * @param pageNum
     * @param pageSize
     * @param tagListDto
     * @return
     */
    @Override
    public ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        // 分页查询
        LambdaQueryWrapper<Tag> tagWrapper = new LambdaQueryWrapper<>();
        tagWrapper.eq(StringUtils.hasText(tagListDto.getName()), Tag::getName, tagListDto.getName());
        tagWrapper.eq(StringUtils.hasText(tagListDto.getRemark()), Tag::getRemark, tagListDto.getRemark());

        Page<Tag> page = new Page<>(pageNum, pageSize);
        page(page, tagWrapper);

        PageVo pageVo = new PageVo(page.getRecords(), page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 新增标签
     * @param tag
     * @return
     */
    @Override
    public ResponseResult addTag(Tag tag) {
        if(!StringUtils.hasText(tag.getName())) {
            throw new SystemException(HttpCodeEnum.TAG_IS_NULL);
        }

        save(tag);
        return ResponseResult.okResult();
    }

    /**
     * 逻辑删除标签
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteTag(List<String> id) {
        tagMapper.deleteTag(id);

        return ResponseResult.okResult();
    }

    /**
     * 获取某个标签
     * @param id
     * @return
     */
    @Override
    public ResponseResult getTag(String id) {
        Tag tag = getById(id);

        return ResponseResult.okResult(tag);
    }

    /**
     * 更新标签
     * @param tag
     * @return
     */
    @Override
    public ResponseResult updateTag(Tag tag) {
        updateById(tag);

        return ResponseResult.okResult();
    }

    /**
     * 获取所有标签
     * @return
     */
    @Override
    public ResponseResult listAllTag() {
        List<Tag> tags = list();

        List<TagVo> tagVos = BeanCopyUtils.copyBeanList(tags, TagVo.class);

        return ResponseResult.okResult(tagVos);
    }
}
