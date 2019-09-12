package com.bbs.controller.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.dto.topic.ManagerTopicPageQueryDto;
import com.bbs.result.DataResult;
import com.bbs.service.IThemeService;
import com.bbs.service.ITopicService;
import com.bbs.vo.topic.ManagerTopicPageQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 帖子管理
 * @author: zhenglubo
 * @create: 2019-09-09 15:44
 **/

@Api(tags = "管理端-帖子")
@RestController
@RequestMapping("/admin/topic")
public class TopicManagerController {

    @Autowired
    private ITopicService topicService;

    @ApiOperation(value = "分页查询帖子")
    @PostMapping(value = "/pageQuery")
    public DataResult<IPage<ManagerTopicPageQueryVo>> pageQuery(@RequestBody ManagerTopicPageQueryDto dto) {
        return topicService.pageQuery(dto);
    }

    @ApiImplicitParam(name = "topicId",value = "帖子id",defaultValue = "1",dataType = "Integer")
    @ApiOperation(value = "帖子置顶")
    @GetMapping(value = "/setTopicToTop")
    public DataResult<String> setTopicToTop(@RequestParam Long topicId){
        return topicService.setTopicToTop(topicId);
    }

    @ApiImplicitParam(name = "topicId",value = "帖子id",defaultValue = "1",dataType = "Integer")
    @ApiOperation(value = "帖子置为热帖")
    @GetMapping(value = "/setTopicToHot")
    public DataResult<String> setTopicToHot(@RequestParam Long topicId){
        return topicService.setTopicToHot(topicId);
    }

    @ApiImplicitParam(name = "topicId",value = "帖子id",defaultValue = "1",dataType = "Integer")
    @ApiOperation(value = "删除帖子")
    @GetMapping(value = "/deleteTopic")
    public DataResult<String> deleteTopic(@RequestParam Long topicId){
        return topicService.deleteTopic(topicId);
    }
}
