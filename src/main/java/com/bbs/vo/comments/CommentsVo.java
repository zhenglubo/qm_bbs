package com.bbs.vo.comments;

import com.bbs.domain.Images;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 评论vo对象
 * @author: zhenglubo
 * @create: 2019-09-03 17:31
 **/

@Data
public class CommentsVo {

    @ApiModelProperty(value = "评论id")
    private Long commentId;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "评论人")
    private String commentUsername;
    @ApiModelProperty(value = "头像")
    private String commentUserAvatar;
    @ApiModelProperty(value = "评论发布时间")
    private Long commentPublishHour;
    @ApiModelProperty(value = "评论发布时间差",example = "一天前")
    private String commentTimeDiff;
    @ApiModelProperty(value = "点赞数量")
    private Integer likeNum;
    @ApiModelProperty(value = "图片列表")
    private List<Images> imgList;
}
