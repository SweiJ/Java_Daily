package com.swei.controller;

import com.swei.dto.TagListDto;
import com.swei.entity.Tag;
import com.swei.service.TagService;
import com.swei.utils.ResponseResult;
import com.swei.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-28 14:03
 */
@RestController
@RequestMapping("/content/tag")
public class ContentTagController {

    @Autowired
    private TagService tagService;

    /**
     * 查询标签列表 或者根据名称查询
     * @param pageNum
     * @param pageSize
     * @param tagListDto
     * @return
     */
    @RequestMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        return tagService.pageTagList(pageNum, pageSize, tagListDto);
    }

    /**
     * 新增标签
     * @param tag
     * @return
     */
    @PostMapping
    public ResponseResult addTag(@RequestBody Tag tag) {
        return tagService.addTag(tag);
    }

    /**
     * 逻辑删除和批量删除标签
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteTag(@PathVariable List<String> id) {
        return tagService.deleteTag(id);
    }

    /**
     * 获取当前标签信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getTag(@PathVariable String id) {
        return tagService.getTag(id);
    }

    /**
     * 修改标签信息
     * @param tag
     * @return
     */
    @PutMapping
    public ResponseResult updateTag(@RequestBody Tag tag) {
        return tagService.updateTag(tag);
    }

    /**
     * 获取所有标签
     * @return
     */
    @GetMapping("/listAllTag")
    public ResponseResult listAllTag() {
        return tagService.listAllTag();
    }
}
