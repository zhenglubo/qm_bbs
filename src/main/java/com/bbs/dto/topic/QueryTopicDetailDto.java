package com.bbs.dto.topic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: 查询帖子详情dto
 * @author: zhenglubo
 * @create: 2019-09-03 15:22
 **/

@Data
@ApiModel(value = "查询帖子详情dto")
public class QueryTopicDetailDto {

    @ApiModelProperty(value = "帖子id",required = true,position = 1,example = "1")
    @NotNull
    private Long topicId;
    @ApiModelProperty(value = "用户id",required = true,position = 2,example = "3")
    @NotNull
    private Long userId;
}
