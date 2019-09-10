package com.bbs.vo.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 管理端分页查询用户vo
 * @author: zhenglubo
 * @create: 2019-09-10 17:37
 **/

@Data
public class ManagerUserPageQueryVo {

    @ApiModelProperty(value = "user表主键",position = 1)
    private Long id;
    @ApiModelProperty(value = "用户名",position = 2)
    private String username;
    @ApiModelProperty(value = "邮箱",position = 3)
    private String email;
    @ApiModelProperty(value = "积分",position = 4)
    private Integer score;
    @ApiModelProperty(value = "注册时间",position = 5)
    private LocalDateTime createdTime;
}
