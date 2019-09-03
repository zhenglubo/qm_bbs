package com.bbs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="User对象", description="用户表")
public class User extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像地址")
    private String avatar;

    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @ApiModelProperty(value = "电话")
    private String mobile;

    @ApiModelProperty(value = "来源站点")
    private String website;

    @ApiModelProperty(value = "bio")
    private String bio;

    @ApiModelProperty(value = "积分")
    private Integer score;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "发送邮件名称")
    private String telegramName;

    @ApiModelProperty(value = "邮箱提醒")
    private Boolean emailNotification;

    @ApiModelProperty(value = "是否激活用户")
    private Boolean active;

    @ApiModelProperty(value = "是否被删除")
    @TableLogic
    private Boolean isDeleted;

    @ApiModelProperty(value = "注册时间")
    private LocalDateTime createdTime;
}
