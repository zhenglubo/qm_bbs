package com.bbs.dto.user;

import com.bbs.dto.MyPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 管理端用户分页查询dto
 * @author: zhenglubo
 * @create: 2019-09-10 17:41
 **/

@Data
public class ManagerUserPageQueryDto extends MyPage {

    @ApiModelProperty(value = "用户名",example = "清风徐来",position = 3)
    private String username;
}
