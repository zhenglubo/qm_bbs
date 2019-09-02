package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.Topic;
import com.bbs.dto.topic.TopicPageQueryDto;
import com.bbs.mapper.TopicMapper;
import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.service.ITopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbs.vo.TopicPageQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户帖 服务实现类
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements ITopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public DataResult<IPage<TopicPageQueryVo>> pageQueryTopic(TopicPageQueryDto dto) {
        IPage<TopicPageQueryVo> page = new Page<>(dto.getCurrent(),dto.getPageSize());
        page = topicMapper.pageQueryTopic(page,dto);
        return DataResultBuild.success(page);
    }
}
