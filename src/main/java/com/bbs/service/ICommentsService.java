package com.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.domain.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bbs.dto.comment.AddCommentDto;
import com.bbs.dto.comment.CommentPageQueryDto;
import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.vo.comments.CommentsVo;

/**
 * <p>
 * 帖子评论表 服务类
 * </p>
 *
 * @author zlb
 * @since 2019-09-03
 */
public interface ICommentsService extends IService<Comments> {

    /**
     * 分页查询帖子
     * @param dto
     * @return
     */
    DataResult<IPage<CommentsVo>> pageQuery(CommentPageQueryDto dto);

    /**
     * 禁用评论
     * @param commentId
     * @return
     */
    DataResult<String> disableComment(Long commentId);

    /**
     * 新增评论
     * @param dto
     * @return
     */
    DataResult<String> addComment(AddCommentDto dto);

    /**
     * 删除评论
     * @param commentIds
     * @return
     */
    DataResult<String> deletedComments(String commentIds);
}
