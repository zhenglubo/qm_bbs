package com.bbs.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:分页参数
 * @author: zhenglubo
 * @create: 2019-09-06 14:57
 **/

@Data
public class MyPage {

    @ApiModelProperty(value = "当前页",required = true,example = "1",position = 1)
    private int current = 1;
    @ApiModelProperty(value = "每一页大小",required = true,example = "10",position = 2)
    private int pageSize = 10;
}
