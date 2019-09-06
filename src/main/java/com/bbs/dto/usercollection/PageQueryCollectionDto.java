package com.bbs.dto.usercollection;

import com.bbs.dto.MyPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: 分页查询收藏dto对象
 * @author: zhenglubo
 * @create: 2019-09-06 14:57
 **/

@Data
public class PageQueryCollectionDto extends MyPage {

    @ApiModelProperty(value = "用户id",example = "4",position = 1,required = true)
    @NotNull
    private Long userId;
}

