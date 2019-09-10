package com.bbs.vo.comments;

import com.bbs.vo.ImageDownloadVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @description: 管理端评论vo
 * @author: zhenglubo
 * @create: 2019-09-10 14:43
 **/

@Data
public class ManagerCommentsVo {

    @ApiModelProperty(value = "评论id",position = 1)
    private Long commentId;
    @ApiModelProperty(value = "帖子id",position = 1)
    private String topicTitle;
    @ApiModelProperty(value = "用户名",position = 1)
    private String username;
    @ApiModelProperty(value = "创建时间",position = 1)
    private LocalDateTime createdTime;
    @ApiModelProperty(value = "评论内容",position = 1)
    private String commentContent;
    @ApiModelProperty(value = "上传的图片",position = 1)
    private List<ImageDownloadVo> imgs;
}
