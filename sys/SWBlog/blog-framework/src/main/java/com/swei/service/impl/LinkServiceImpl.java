package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.constants.SystemConstants;
import com.swei.dto.LinkListDto;
import com.swei.entity.Link;
import com.swei.mapper.LinkMapper;
import com.swei.service.LinkService;
import com.swei.utils.BeanCopyUtils;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.LinkVo;
import com.swei.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2022-08-25 08:52:46
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    /**
     * 前台获取所有友联
     * @return
     */
    @Override
    public ResponseResult getAllLink() {
        // 获取所有状态为已审核的友联
        LambdaQueryWrapper<Link> linkWrapper = new LambdaQueryWrapper<>();
        linkWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);

        List<Link> links = list(linkWrapper);
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);

        return ResponseResult.okResult(linkVos);
    }

    /**
     * 后台获取友联列表信息
     * @param pageNum
     * @param pageSize
     * @param linkListDto
     * @return
     */
    @Override
    public ResponseResult getLinkList(Integer pageNum, Integer pageSize, LinkListDto linkListDto) {
        // 分页
        LambdaQueryWrapper<Link> linkWrapper = new LambdaQueryWrapper<>();
        linkWrapper.eq(StringUtils.hasText(linkListDto.getName()), Link::getName, linkListDto.getName());
        linkWrapper.eq(StringUtils.hasText(linkListDto.getStatus()), Link::getStatus, linkListDto.getStatus());

        Page<Link> page = new Page<>(pageNum, pageSize);
        page(page, linkWrapper);

        PageVo pageVo = new PageVo(page.getRecords(), page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 新增友联
     * @param link
     * @return
     */
    @Override
    public ResponseResult addLink(Link link) {
        if(!StringUtils.hasText(link.getName())) {
            throw new SystemException(HttpCodeEnum.LINK_IS_NULL);
        }

        save(link);
        return ResponseResult.okResult();
    }

    /**
     * 逻辑删除和批量删除友联
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteLink(List<String> id) {
        linkMapper.deleteLink(id);

        return ResponseResult.okResult();
    }

    /**
     * 获取友联信息
     * @param id
     * @return
     */
    @Override
    public ResponseResult getLink(String id) {
        Link link = getById(id);

        return ResponseResult.okResult(link);
    }

    /**
     * 修改友联信息
     * @param link
     * @return
     */
    @Override
    public ResponseResult updateLink(Link link) {
        updateById(link);

        return ResponseResult.okResult();
    }

    /**
     * 修改友联状态
     * @param link
     * @return
     */
    @Override
    public ResponseResult changeLinkStatus(Link link) {
//        LambdaQueryWrapper<Link> linkWrapper = new LambdaQueryWrapper<>();
//        linkWrapper.eq(Link::getId, link.getId());
//        update(linkWrapper);
        updateById(link);

        return ResponseResult.okResult();
    }
}
