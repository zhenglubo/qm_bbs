package com.bbs.dto.topic;

import com.bbs.dto.MyPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 帖子分页查询dto
 * @author: zhenglubo
 * @create: 2019-09-02 18:17
 **/

@Data
public class TopicPageQueryDto extends MyPage {

    @ApiModelProperty(value = "每一页大小",required = true,example = "10",position = 3)
    private Long userId ;

}
