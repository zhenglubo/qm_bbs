package com.bbs.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.dto.topic.TopicPageQueryDto;
import com.bbs.result.DataResult;
import com.bbs.service.ITopicService;
import com.bbs.vo.TopicPageQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户帖 前端控制器
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
@RestController
@RequestMapping("/topic")
@Api(tags = "用户贴子controller")
public class TopicController {

    @Autowired
    private ITopicService topicService;

    @ApiOperation("分页查询帖子")
    @PostMapping("/pageQuery")
    public DataResult<IPage<TopicPageQueryVo>> pageQueryTopic(@RequestBody TopicPageQueryDto dto){
        return topicService.pageQueryTopic(dto);
    }
}
