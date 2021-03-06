package com.bbs.dto.comment;

import com.bbs.dto.MyPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @description: 管理端分页查询帖子dto
 * @author: zhenglubo
 * @create: 2019-09-10 14:40
 **/

@Data
public class ManagerCommentPageQueryDto extends MyPage {

    @ApiModelProperty(value = "开始时间", example = "2019-08-30", position = 3)
    private LocalDate beginDate;
    @ApiModelProperty(value = "结束时间", example = "2019-09-02", position = 4)
    private LocalDate endDate;
    @ApiModelProperty(value = "用户名", example = "清风徐来", position = 5)
    private String username;
}
