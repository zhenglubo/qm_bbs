package com.bbs.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 用户注册dto
 * @author: zhenglubo
 * @create: 2019-09-02 14:30
 **/

@Data
@ApiModel(value = "用户注册dto")
public class UserRegisterDto {

    @ApiModelProperty(name = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(name = "邮箱地址")
    @NotBlank(message = "邮箱地址不能为空")
    private String email;
    @ApiModelProperty(name = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;
    @ApiModelProperty(name = "验证码")
    @NotBlank(message = "验证码不能为空")
    private String verificationCode;
}
