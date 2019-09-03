package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.constant.Number;
import com.bbs.domain.Topic;
import com.bbs.dto.topic.QueryTopicDetailDto;
import com.bbs.dto.topic.TopicPageQueryDto;
import com.bbs.mapper.TopicMapper;
import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.service.ITopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbs.vo.topic.TopicDetailVo;
import com.bbs.vo.topic.TopicPageQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        IPage<TopicPageQueryVo> page = new Page<>(dto.getCurrent(), dto.getPageSize());
        page = topicMapper.pageQueryTopic(page, dto);
        if (!CollectionUtils.isEmpty(page.getRecords())) {
            page.getRecords().stream().forEach(record ->
                record.setPublishTime(calculateTimeDiff(record.getPublishHours()))
            );
        }
        return DataResultBuild.success(page);
    }

    @Override
    public DataResult<TopicDetailVo> queryDetail(QueryTopicDetailDto dto) {

        return null;
    }

    private String calculateTimeDiff(long hours) {
        String timeDiff;
        if (hours < 0L) {
            timeDiff = "刚刚";
        } else if (hours < Number.ONE_DAY.getValue()) {
            timeDiff = hours + "小时前";
        } else if ((hours / Number.ONE_DAY.getValue()) >= 1 && ((hours / Number.ONE_DAY.getValue()) <= Number.ON_MONTH.getValue())) {
            return (hours / Number.ONE_DAY.getValue()) + "天前";
        } else if ((hours / (Number.ONE_DAY.getValue() * Number.ON_MONTH.getValue())) >= 1 && (hours / (Number.ONE_DAY.getValue() * Number.ON_MONTH.getValue())) < Number.ONE_YEAR.getValue()) {
            return (hours / (24 * 30)) + "个月前";
        } else {
            return (hours / (24 * 30 * 12)) + "年前";
        }
        return timeDiff;
    }
}
