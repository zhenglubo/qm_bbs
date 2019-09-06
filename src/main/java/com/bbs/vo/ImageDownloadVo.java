package com.bbs.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 图片下载地址vo对象
 * @author: zhenglubo
 * @create: 2019-09-04 15:47
 **/

@Data
public class ImageDownloadVo {

    @ApiModelProperty(value = "主键id",position = 1)
    private Long id;
    @ApiModelProperty(value = "图片下载地址",position = 2)
    private String downloadUrl;
}
