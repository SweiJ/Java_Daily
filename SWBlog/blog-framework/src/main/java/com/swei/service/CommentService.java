package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.entity.Comment;
import com.swei.utils.ResponseResult;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2022-08-25 15:04:00
 */
public interface CommentService extends IService<Comment> {

    /**
     * 获取当前文章评论列表
     * @param articleId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseResult commentList(String type, Long articleId, Integer pageNum, Integer pageSize);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    ResponseResult addComment(Comment comment);
}

