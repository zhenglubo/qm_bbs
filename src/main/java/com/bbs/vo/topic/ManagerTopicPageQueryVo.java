package com.bbs.vo.topic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 管理端分页查询vo对象
 * @author: zhenglubo
 * @create: 2019-09-09 16:53
 **/

@Data
public class ManagerTopicPageQueryVo {

    @ApiModelProperty(value = "topic表主键id",position = 1)
    private Long id;
    @ApiModelProperty(value = "标题",position = 2)
    private String title;
    @ApiModelProperty(value = "用户名",position = 3)
    private String username;
    @ApiModelProperty(value = "评论数",position = 4)
    private Integer commentCount;
    @ApiModelProperty(value = "浏览数",position = 5)
    private Integer viewCount;
    @ApiModelProperty(value = "是否被删除",position = 6)
    private Boolean isDeleted;
    @ApiModelProperty(value = "创建时间",position = 7)
    private LocalDateTime createdTime;
}
