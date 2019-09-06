package com.bbs.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.dto.comment.AddCommentDto;
import com.bbs.dto.comment.CommentPageQueryDto;
import com.bbs.result.DataResult;
import com.bbs.service.ICommentsService;
import com.bbs.vo.comments.CommentsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 帖子评论表 前端控制器
 * </p>
 *
 * @author zlb
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/comments")
@Api(tags = "帖子评论")
public class CommentsController {

    @Autowired
    private ICommentsService commentsService;

    @ApiOperation("分页查询帖子")
    @PostMapping("/pageQuery")
    public DataResult<IPage<CommentsVo>> pageQuery(@RequestBody CommentPageQueryDto dto){
        return commentsService.pageQuery(dto);
    }

    @ApiImplicitParam(name = "commentId",value = "评论id",defaultValue = "1",paramType = "path")
    @ApiOperation("禁用评论")
    @GetMapping(value = "/disableComment/{commentId}")
    public DataResult<String> disableComment(@PathVariable Long commentId){
        return commentsService.disableComment(commentId);
    }

    @ApiOperation("新增评论")
    @PostMapping(value = "addComment")
    public DataResult<String> addCommment(@RequestBody AddCommentDto dto){
        return commentsService.addComment(dto);
    }

    @ApiImplicitParam(name = "commentIds",value = "评论ids",defaultValue = "1,2,3",paramType = "path")
    @ApiOperation("删除评论")
    @GetMapping(value = "/deletedComments/{comm}")
    public DataResult<String> deletedComments(@PathVariable String commentIds){
        return commentsService.deletedComments(commentIds);
    }
}
