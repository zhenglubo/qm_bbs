package com.bbs.dto.usercollection;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: 新增收藏dto对象
 * @author: zhenglubo
 * @create: 2019-09-06 14:30
 **/

@Data
public class AddCollectionDto {

    @ApiModelProperty(value = "用户id",example = "4",position = 1,required = true)
    @NotNull
    private Long userId;
    @ApiModelProperty(value = "帖子或主题id",example = "1",position = 2,required = true)
    @NotNull
    private Long collectionId;
    @ApiModelProperty(value = "主题或帖子（topic或theme）",example = "topic",position = 3,required = true)
    @NotBlank
    private String type;
}
