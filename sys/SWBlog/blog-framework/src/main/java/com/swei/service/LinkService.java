package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.dto.LinkListDto;
import com.swei.entity.Link;
import com.swei.utils.ResponseResult;

import java.util.List;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-08-25 08:52:45
 */
public interface LinkService extends IService<Link> {


    /**
     * 获取所有的友联
     * @return
     */
    ResponseResult getAllLink();

    /**
     * 获取友联列表信息
     * @param pageNum
     * @param pageSize
     * @param linkListDto
     * @return
     */
    ResponseResult getLinkList(Integer pageNum, Integer pageSize, LinkListDto linkListDto);

    /**
     * 新增友联
     * @param link
     * @return
     */
    ResponseResult addLink(Link link);

    /**
     * 逻辑删除和批量删除友联
     * @param id
     * @return
     */
    ResponseResult deleteLink(List<String> id);

    /**
     * 获取友联信息
     * @param id
     * @return
     */
    ResponseResult getLink(String id);

    /**
     * 修改友联信息
     * @param link
     * @return
     */
    ResponseResult updateLink(Link link);

    /**
     * 修改友联状态
     * @param link
     * @return
     */
    ResponseResult changeLinkStatus(Link link);
}

