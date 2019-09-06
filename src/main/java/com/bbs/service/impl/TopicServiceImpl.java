package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.Images;
import com.bbs.domain.Topic;
import com.bbs.dto.topic.QueryTopicDetailDto;
import com.bbs.dto.topic.TopicAddDto;
import com.bbs.dto.topic.TopicPageQueryDto;
import com.bbs.mapper.CommentsMapper;
import com.bbs.mapper.ImagesMapper;
import com.bbs.mapper.TopicMapper;
import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.service.ITopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbs.uitls.OssUtil;
import com.bbs.uitls.TimeUtil;
import com.bbs.vo.comments.CommentsVo;
import com.bbs.vo.topic.TopicDetailVo;
import com.bbs.vo.topic.TopicPageQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private ImagesMapper imagesMapper;

    @Autowired
    private OssUtil ossUtil;

    /**
     * 分页查询帖子
     *
     * @param dto
     * @return
     */
    @Override
    public DataResult<IPage<TopicPageQueryVo>> pageQueryTopic(TopicPageQueryDto dto) {
        IPage<TopicPageQueryVo> page = new Page<>(dto.getCurrent(), dto.getPageSize());
        page = topicMapper.pageQueryTopic(page, dto);
        if (!CollectionUtils.isEmpty(page.getRecords())) {
            page.getRecords().stream().forEach(record ->
                    record.setPublishTime(TimeUtil.calculateTimeDiff(record.getPublishHours()))
            );
        }
        return DataResultBuild.success(page);
    }

    /**
     * 查询帖子详情
     *
     * @param dto
     * @return
     */
    @Override
    public DataResult<TopicDetailVo> queryDetail(QueryTopicDetailDto dto) {
        TopicDetailVo detailVo = topicMapper.selectDetailWithComment(dto);
        if (detailVo != null) {
            detailVo.setPublishTime(TimeUtil.calculateTimeDiff(detailVo.getPublishHours()));
            Page<CommentsVo> page = new Page<>(1, 10);
            List<CommentsVo> commentsVoList = commentsMapper.selectByTopicId(page, dto.getTopicId());
            commentsVoList.stream().forEach(record -> record.setCommentTimeDiff(TimeUtil.calculateTimeDiff(record.getCommentPublishHour())));
            detailVo.setCommentsVoList(commentsVoList);
        }
        return DataResultBuild.success(detailVo);
    }

    /**
     * 新增帖子
     *
     * @param dto
     * @param file
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public DataResult<Topic> addTopic(TopicAddDto dto, MultipartFile[] file) {
        Topic topic = new Topic();
        BeanUtils.copyProperties(dto, topic);
        topic.setViewCount(1);
        int result = topicMapper.insert(topic);
        if (result > 0) {
            Long topicId = topic.getId();
            Long userId = topic.getUserId();
            if (file != null && file.length > 0) {
                //图片上传
                Images images = new Images();
                String downloadUrl;
                for (int i = 0; i < file.length; i++) {
                    MultipartFile multipartFile = file[i];
                    downloadUrl = ossUtil.uploadFile(multipartFile, "topic", dto.getUserId().toString());
                    images.setDownloadUrl(downloadUrl);
                    images.setTopicId(topicId);
                    images.setUserId(userId);
                    imagesMapper.insert(images);
                }
            }
        }
        return DataResultBuild.success(topic);
    }


}
