package com.bbs.dto.comment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: CommentPageQuerydto
 * @author: zhenglubo
 * @create: 2019-09-06 09:05
 **/

@Data
public class CommentPageQueryDto {

    @ApiModelProperty(value = "帖子id",required = true,example = "1",position = 1)
    private Long topicId;
    @ApiModelProperty(value = "当前页",required = true,example = "1",position = 2)
    private int current = 1;
    @ApiModelProperty(value = "每一页大小",required = true,example = "10",position = 3)
    private int pageSize = 10;
}
