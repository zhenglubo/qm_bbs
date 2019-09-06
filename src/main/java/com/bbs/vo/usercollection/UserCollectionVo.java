package com.bbs.vo.usercollection;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author: zhenglubo
 * @create: 2019-09-06 17:10
 **/

@Data
public class UserCollectionVo {

    @ApiModelProperty(value = "topic id 或theme id", example = "1", position = 1)
    private Long id;
    @ApiModelProperty(value = "标题", example = "xxx", position = 2)
    private String title;
    @ApiModelProperty(value = "内容", example = "xxx", position = 3)
    private String content;
    @ApiModelProperty(value = "topic 或 theme", example = "topic", position = 4)
    private String type;
}
