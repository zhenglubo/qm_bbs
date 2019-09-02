package com.bbs.dto.topic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 帖子分页查询dto
 * @author: zhenglubo
 * @create: 2019-09-02 18:17
 **/

@Data
public class TopicPageQueryDto {

    @ApiModelProperty(value = "用户id",required = false,example = "1",position = 1)
    private Long userId;
    @ApiModelProperty(value = "当前页",required = true,example = "1",position = 2)
    private int current = 1;
    @ApiModelProperty(value = "每一页大小",required = true,example = "10",position = 3)
    private int pageSize = 10;

}
