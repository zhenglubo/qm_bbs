package com.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.domain.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bbs.dto.comment.AddCommentDto;
import com.bbs.dto.comment.CommentPageQueryDto;
import com.bbs.dto.comment.ManagerCommentPageQueryDto;
import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.vo.comments.CommentsVo;
import com.bbs.vo.comments.ManagerCommentsVo;

import java.time.LocalDateTime;

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

    /**
     * 今日新增评论数量
     * @param begin
     * @param end
     * @return
     */
    int countTodayAddNum(LocalDateTime begin,LocalDateTime end);

    /**
     * 管理端-分页查询帖子
     * @param dto
     * @return
     */
    DataResult<IPage<ManagerCommentsVo>> pageQueryComments(ManagerCommentPageQueryDto dto);

    /**
     * 管理端-删除评论
     * @param commentId
     * @return
     */
    DataResult<String> deleteComment(Long commentId);
}
