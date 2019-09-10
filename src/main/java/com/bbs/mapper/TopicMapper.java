package com.bbs.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.Images;
import com.bbs.domain.Topic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbs.dto.topic.ManagerTopicPageQueryDto;
import com.bbs.dto.topic.QueryTopicDetailDto;
import com.bbs.dto.topic.TopicPageQueryDto;
import com.bbs.vo.topic.ManagerTopicPageQueryVo;
import com.bbs.vo.topic.TopicDetailVo;
import com.bbs.vo.topic.TopicPageQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    /**
     * 查询所有图片
     * @param id
     * @return
     */
    List<Images> getImages(Long id);

    /**
     * 管理端-查看贴子详情
     * @param dto
     * @return
     */
    TopicDetailVo selectDetailWithComment(@Param(value = "dto") QueryTopicDetailDto dto);

    /**
     * 管理端-分页查询帖子信息
     * @param page
     * @param dto
     * @return
     */
    Page<ManagerTopicPageQueryVo> selectTopicInfoForManager(@PathVariable("page") Page<ManagerTopicPageQueryVo> page, @Param("dto") ManagerTopicPageQueryDto dto);
}
