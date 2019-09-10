package com.bbs.controller.manager;

import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.service.ICommentsService;
import com.bbs.service.IThemeService;
import com.bbs.service.ITopicService;
import com.bbs.service.IUserService;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 管理端首页
 * @author: zhenglubo
 * @create: 2019-09-09 14:50
 **/

@RestController
@RequestMapping(value = "/admin")
@Api(tags = "管理端-首页")
public class IndexController {
    @Autowired
    private ITopicService topicService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IThemeService themeService;
    @Autowired
    private ICommentsService commentsService;

    @ApiOperation(value = "获取首页相关信息")
    @GetMapping(value = "/index")
    public DataResult getIndexInfo(){
        LocalDateTime begin = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime end = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        //今日新增帖子数
        int topicAddNum = topicService.countTodayAddNum(begin,end);
        //今日新增主题数
        int themeAddNum = themeService.countTodayAddNum(begin,end);
        //今日新增评论数
        int commentAddNum = commentsService.countTodayAddNum(begin,end);
        //今日新增用户数
        int userAddNum = userService.countTodayAddNum(begin,end);
        Map<String,Integer> map = Maps.newHashMap();
        map.put("topicAddNum",topicAddNum);
        map.put("themeAddNum",themeAddNum);
        map.put("commentAddNum",commentAddNum);
        map.put("userAddNum",userAddNum);
        return DataResultBuild.success(map);
    }

}
