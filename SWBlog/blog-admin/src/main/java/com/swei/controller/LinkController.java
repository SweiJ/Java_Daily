package com.swei.controller;

import com.swei.dto.LinkListDto;
import com.swei.entity.Link;
import com.swei.service.LinkService;
import com.swei.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-29 8:08
 */
@RestController
@RequestMapping("/content/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    /**
     * 获取友联列表信息
     * @param pageNum
     * @param pageSize
     * @param linkListDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult getLinkList(Integer pageNum, Integer pageSize, LinkListDto linkListDto) {
        return linkService.getLinkList(pageNum, pageSize, linkListDto);
    }

    /**
     * 新增友联
     * @param link
     * @return
     */
    @PostMapping
    public ResponseResult addLink(@RequestBody Link link) {
        return linkService.addLink(link);
    }

    /**
     * 逻辑删除和批量删除友联
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteLink(@PathVariable List<String> id) {
        return linkService.deleteLink(id);
    }

    /**
     * 获取当前友联信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getLink(@PathVariable String id) {
        return linkService.getLink(id);
    }

    /**
     * 修改友联信息
     * @param link
     * @return
     */
    @PutMapping
    public ResponseResult updateLink(@RequestBody Link link) {
        return linkService.updateLink(link);
    }

    @PutMapping("/changeLinkStatus")
    public ResponseResult changeLinkStatus(@RequestBody Link link) {
        return linkService.changeLinkStatus(link);
    }
}
