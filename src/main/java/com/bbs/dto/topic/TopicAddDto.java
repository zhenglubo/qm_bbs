package com.bbs.dto.topic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: 帖子新增dto对象
 * @author: zhenglubo
 * @create: 2019-09-04 16:00
 **/

@Data
public class TopicAddDto {

    @ApiModelProperty(value = "用户id")
    @NotNull
    private Long userId;
    @ApiModelProperty(value = "标题")
    @NotBlank
    private String title;
    @NotBlank
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "微信号")
    private String wechat;
    @ApiModelProperty(value = "qq号码")
    private String qq;
}
