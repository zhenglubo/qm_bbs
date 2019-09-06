package com.bbs.dto.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description: 新增评论
 * @author: zhenglubo
 * @create: 2019-09-06 10:08
 **/

@Data
@ApiModel(value = "新增评论dto对象")
public class AddCommentDto {

    @ApiModelProperty(value = "帖子id",example = "1",position = 1,required = true)
    @NotNull
    private Long topicId;

    @ApiModelProperty(value = "评论的内容",example = "xxxxx",position = 2,required = true)
    @NotBlank
    private String content;

    @ApiModelProperty(value = "用户id",example = "2",position = 3,required = true)
    @NotNull
    private Long userId;

    @ApiModelProperty(value = "上传的图片列表")
    private MultipartFile[] multipartFiles;
}
