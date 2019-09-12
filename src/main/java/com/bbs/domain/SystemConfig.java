package com.bbs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统配置表
 * </p>
 *
 * @author zlb
 * @since 2019-09-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SystemConfig对象", description="系统配置表")
public class SystemConfig extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "系统配置名称")

    private String systemKey;

    @ApiModelProperty(value = "系统配置值")
    private String systemValue;

    @ApiModelProperty(value = "系统配置描述")
    private String description;

    @ApiModelProperty(value = "优先级")
    private Integer pid;

    @ApiModelProperty(value = "数据类型")
    private String type;

    @ApiModelProperty(value = "是否可选")
    private String systemOption;

    @ApiModelProperty(value = "重启")
    private Integer reboot;


}
