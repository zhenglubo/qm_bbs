package com.bbs.controller.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.dto.comment.ManagerCommentPageQueryDto;
import com.bbs.result.DataResult;
import com.bbs.service.ICommentsService;
import com.bbs.vo.comments.ManagerCommentsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 帖子评论管理
 * @author: zhenglubo
 * @create: 2019-09-10 14:37
 **/

@Api(tags = "管理端-评论管理")
@RestController
@RequestMapping("/admin/comments")
public class CommentsManagerController {

    @Autowired
    private ICommentsService commentsService;

    @ApiOperation("分页查询评论")
    @PostMapping(value = "/pageQueryComments")
    public DataResult<IPage<ManagerCommentsVo>> pageQueryComments(@RequestBody ManagerCommentPageQueryDto dto){
        return commentsService.pageQueryComments(dto);
    }

    @ApiImplicitParam(name = "commentId",value = "评论id",defaultValue = "1",required = true)
    @ApiOperation("删除评论")
    @GetMapping(value = "/deleteComment")
    public DataResult<String> deleteComment(@RequestParam Long commentId){
        return commentsService.deleteComment(commentId);
    }
}
