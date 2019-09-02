package com.bbs.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: 帖子分页查询下对象
 * @author: zhenglubo
 * @create: 2019-09-02 18:04
 **/

@Data
@ApiModel(value = "帖子分页查询api")
public class TopicPageQueryVo {

    @ApiModelProperty(value = "帖子id")
    private Long id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "作者")
    private String author;
    @ApiModelProperty(value = "图片地址列表")
    private List<String> uploadImgIds;
    @ApiModelProperty(value = "评论数量")
    private Integer commentCount;
    @ApiModelProperty(value = "浏览次数")
    private Integer viewCount;
    @ApiModelProperty(value = "发表时间(小时数)")
    private Long publishHours;
    @ApiModelProperty(value = "发表时间")
    private String publishTime;

}
