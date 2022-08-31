package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.dto.TagListDto;
import com.swei.entity.Tag;
import com.swei.utils.ResponseResult;
import com.swei.vo.PageVo;

import java.util.List;


/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2022-08-28 14:00:20
 */
public interface TagService extends IService<Tag> {

    /**
     * 返回标签列表
     * @param pageNum
     * @param pageSize
     * @param tagListDto
     * @return
     */
    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);

    /**
     * 新增标签
     * @param tag
     * @return
     */
    ResponseResult addTag(Tag tag);

    /**
     * 删除标签
     * @param id
     * @return
     */
    ResponseResult deleteTag(List<String> id);

    /**
     * 获取标签
     * @param id
     * @return
     */
    ResponseResult getTag(String id);

    /**
     * 修改标签
     * @param tag
     * @return
     */
    ResponseResult updateTag(Tag tag);

    /**
     * 获取所有标签
     * @return
     */
    ResponseResult listAllTag();
}

