package com.bbs.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.Comments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbs.domain.Images;
import com.bbs.vo.comments.CommentsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 帖子评论表 Mapper 接口
 * </p>
 *
 * @author zlb
 * @since 2019-09-03
 */
public interface CommentsMapper extends BaseMapper<Comments> {

    /**
     * 分页查询帖子对应的评论
     * @param page
     * @param topicId
     * @return
     */
    List<CommentsVo> selectByTopicId(@Param(value = "page") Page<CommentsVo> page, @Param(value = "topicId") Long topicId);

    /**
     * 查询所有图片
     * @param id
     * @return
     */
    List<Images> getImages(Long id);
}
