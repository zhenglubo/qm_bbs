package com.bbs.vo.topic;

import com.bbs.domain.Images;
import com.bbs.vo.ImageDownloadVo;
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

    @ApiModelProperty(value = "帖子id",position = 1)
    private Long id;
    @ApiModelProperty(value = "标题",position = 2)
    private String title;
    @ApiModelProperty(value = "内容",position = 3)
    private String content;
    @ApiModelProperty(value = "作者",position = 4)
    private String author;
    @ApiModelProperty(value = "头像",position = 5)
    private String avatar;
    @ApiModelProperty(value = "评论数量",position = 6)
    private Integer commentCount;
    @ApiModelProperty(value = "浏览次数",position = 7)
    private Integer viewCount;
    @ApiModelProperty(value = "发表时间(小时数)",position = 8)
    private Long publishHours;
    @ApiModelProperty(value = "发表时间",position = 9)
    private String publishTime;
    @ApiModelProperty(value = "图片地址列表",position = 10)
    private List<ImageDownloadVo> uploadImgIds;

}
