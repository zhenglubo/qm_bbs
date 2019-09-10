package com.bbs.dto.comment;

import com.bbs.dto.MyPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: CommentPageQuerydto
 * @author: zhenglubo
 * @create: 2019-09-06 09:05
 **/

@Data
public class CommentPageQueryDto extends MyPage {

    @ApiModelProperty(value = "帖子id",required = true,example = "1",position = 3)
    private Long topicId;
}
