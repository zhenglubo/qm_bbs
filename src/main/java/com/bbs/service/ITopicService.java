package com.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.domain.Topic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bbs.dto.topic.ManagerTopicPageQueryDto;
import com.bbs.dto.topic.QueryTopicDetailDto;
import com.bbs.dto.topic.TopicAddDto;
import com.bbs.dto.topic.TopicPageQueryDto;
import com.bbs.result.DataResult;
import com.bbs.vo.topic.ManagerTopicPageQueryVo;
import com.bbs.vo.topic.TopicDetailVo;
import com.bbs.vo.topic.TopicPageQueryVo;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户帖 服务类
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
public interface ITopicService extends IService<Topic> {

    /**
     * 分页查询帖子
     *
     * @param dto
     * @return
     */
    DataResult<IPage<TopicPageQueryVo>> pageQueryTopic(TopicPageQueryDto dto);

    /**
     * 查询帖子详情
     *
     * @param dto
     * @return
     */
    DataResult<TopicDetailVo> queryDetail(QueryTopicDetailDto dto);

    /**
     * 新增话题
     *
     * @param dto
     * @param file
     * @return
     */
    DataResult<Topic> addTopic(TopicAddDto dto, MultipartFile[] file);

    /**
     * 管理端-今日新增帖子数量
     *
     * @param begin
     * @param end
     * @return
     */
    int countTodayAddNum(LocalDateTime begin, LocalDateTime end);

    /**
     * 管理端-分页查询
     *
     * @param dto
     * @return
     */
    DataResult<IPage<ManagerTopicPageQueryVo>> pageQuery(ManagerTopicPageQueryDto dto);

    /**
     * 管理端-帖子置顶
     * @param topicId
     * @return
     */
    DataResult<String> setTopicToTop(Long topicId);

    /**
     * 管理端-置为热帖
     * @param topicId
     * @return
     */
    DataResult<String> setTopicToHot(Long topicId);

    /**
     * 删除帖子
     * @param topicId
     * @return
     */
    DataResult<String> deleteTopic(Long topicId);
}
