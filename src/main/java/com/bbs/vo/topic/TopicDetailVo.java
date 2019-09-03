package com.bbs.vo.topic;

import com.bbs.domain.Images;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 帖子详情
 * @author: zhenglubo
 * @create: 2019-09-03 16:51
 **/

@Data
public class TopicDetailVo extends TopicPageQueryVo{

    @ApiModelProperty(value = "评论人")
    private String commentUsername;
    @ApiModelProperty(value = "头像")
    private String commentUserAvatar;
    @ApiModelProperty(value = "评论内容")
    private String content;
    @ApiModelProperty(value = "发布距离现在小时数")
    private String commentPublishHours;
    @ApiModelProperty(value = "发布时间")
    private String commentPublishTimeDiff;
    @ApiModelProperty(value = "点赞数")
    private Integer likeNum;
    @ApiModelProperty(value = "点赞图片列表")
    private List<Images> commentImageList;

}
