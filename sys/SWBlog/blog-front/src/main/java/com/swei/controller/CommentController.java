package com.swei.controller;

import com.swei.constants.SystemConstants;
import com.swei.dto.AddCommentDto;
import com.swei.entity.Comment;
import com.swei.service.CommentService;
import com.swei.utils.BeanCopyUtils;
import com.swei.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-25 15:11
 */
@RestController
@RequestMapping("/comment")
@Api(tags="评论")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentList")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {
        return commentService.commentList(SystemConstants.ARTICLE_COMMENT_TYPE, articleId, pageNum, pageSize);
    }

    @PostMapping
    public ResponseResult addComment(@RequestBody AddCommentDto addCommentDto) {
        Comment comment = BeanCopyUtils.copyBean(addCommentDto, Comment.class);
        return commentService.addComment(comment);
    }

    @ApiOperation(value = "友联评论列表", notes = "获取一页友联评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页号"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小")
    })
    @GetMapping("/linkCommentList")
    public ResponseResult getLinkCommentList(Integer pageNum, Integer pageSize) {
        return commentService.commentList(SystemConstants.LINK_COMMENT_TYPE,null, pageNum, pageSize);
    }
}
