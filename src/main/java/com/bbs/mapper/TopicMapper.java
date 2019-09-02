package com.bbs.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.domain.Topic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbs.dto.topic.TopicPageQueryDto;
import com.bbs.vo.TopicPageQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户帖 Mapper 接口
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
@Mapper
public interface TopicMapper extends BaseMapper<Topic> {

    /**
     * 分页查询帖子
     * @param page
     * @param dto
     * @return
     */
    IPage<TopicPageQueryVo> pageQueryTopic(@Param(value = "page") IPage<TopicPageQueryVo> page, @Param(value = "dto") TopicPageQueryDto dto);
}