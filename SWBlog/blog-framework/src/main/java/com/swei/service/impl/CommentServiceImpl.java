package com.swei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swei.SystemException;
import com.swei.constants.SystemConstants;
import com.swei.entity.Comment;
import com.swei.entity.LoginUser;
import com.swei.mapper.CommentMapper;
import com.swei.service.CommentService;
import com.swei.service.UserService;
import com.swei.utils.BeanCopyUtils;
import com.swei.utils.ResponseResult;
import com.swei.utils.SecurityUtils;
import com.swei.utils.enums.HttpCodeEnum;
import com.swei.vo.CommentVo;
import com.swei.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 评论表(Comment)表服务实现类
 *
 * @author makejava
 * @since 2022-08-25 15:04:00
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private UserService userService;

    @Override
    public ResponseResult commentList(String type, Long articleId, Integer pageNum, Integer pageSize) {
        // 查询当前文章下所有评论
        LambdaQueryWrapper<Comment> commentWrapper = new LambdaQueryWrapper<>();

        // 当前文章所有评论
        commentWrapper.eq(SystemConstants.ARTICLE_COMMENT_TYPE.equals(type), Comment::getArticleId, articleId);
        // 根评论
        commentWrapper.eq(Comment::getRootId, -1);

        commentWrapper.eq(Comment::getType, type);

        // 分页
        Page<Comment> page = new Page<>();
        page(page, commentWrapper);

        // 将分页之后的数据封装成前端需要的类型 commentvo
        List<CommentVo> commentVos = toCommentVoList(page.getRecords());

        // 查询子评论
        for (CommentVo commentVo : commentVos) {
            List<CommentVo> children = getCommentChildren(commentVo.getId());
            commentVo.setChildren(children);
        }
        return ResponseResult.okResult(new PageVo(commentVos, page.getTotal()));
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Override
    public ResponseResult addComment(Comment comment) {
        if(!StringUtils.hasText(comment.getContent())) {
            throw new SystemException(HttpCodeEnum.COMMENT_NOT_NULL);
        }
        save(comment);
        return ResponseResult.okResult();
    }

    /**
     * 获取子评论
     * @param currentCommentId
     * @return
     */
    private List<CommentVo> getCommentChildren(Long currentCommentId) {
        LambdaQueryWrapper<Comment> commentChildrenWrapper = new LambdaQueryWrapper<>();
        // 根评论是当前评论的id
        commentChildrenWrapper.eq(Comment::getRootId, currentCommentId);

        // 查询所有当前评论的子评论
        List<Comment> list = list(commentChildrenWrapper);
        // 转换成commentVo对象
        List<CommentVo> commentVos = toCommentVoList(list);
        return commentVos;
    }

    /**
     * 转换评论对象信息
     * @param list
     * @return
     */
    private List<CommentVo> toCommentVoList(List<Comment> list) {
        List<CommentVo> listVo = BeanCopyUtils.copyBeanList(list, CommentVo.class);

        // 由于comment没有username用户昵称字段 所以需要获取该字段并赋值
        for (CommentVo commentVo : listVo) {
            // 得到当前评论的昵称
            String nickName = userService.getById(commentVo.getCreateBy()).getNickName();
            commentVo.setUsername(nickName);

            // 当前评论必须有所回复的用户id
            if(commentVo.getToCommentUserId() != -1) {
                // 获取回复方用户的昵称
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                commentVo.setToCommentUserName(toCommentUserName);
            }
        }
        return listVo;
    }
}
