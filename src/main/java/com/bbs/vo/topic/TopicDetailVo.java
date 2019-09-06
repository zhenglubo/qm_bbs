package com.bbs.vo.topic;

import com.bbs.vo.comments.CommentsVo;
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

    @ApiModelProperty(value = "评论列表",position = 11)
    private List<CommentsVo> commentsVoList;

}
