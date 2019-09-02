package com.bbs.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 用户登录dto
 * @author: zhenglubo
 * @create: 2019-09-02 15:52
 **/

@Data
@ApiModel(value = "用户登录dto")
public class UserLoginDto {

    @ApiModelProperty(value = "用户名")
    @NotBlank
    private String username;
    @ApiModelProperty(value = "密码")
    @NotBlank
    private String password;
    @ApiModelProperty(value = "验证码")
    @NotBlank
    private String verificationCode;

}
