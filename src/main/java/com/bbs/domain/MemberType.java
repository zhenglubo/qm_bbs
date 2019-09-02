package com.bbs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会员等级表
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="MemberType对象", description="会员等级表")
public class MemberType extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "等级")
    private Integer grade;

    @ApiModelProperty(value = "等级名称")
    private String gradeName;

    @ApiModelProperty(value = "等级别名")
    private String gradeAlias;

    @ApiModelProperty(value = "是否被删除0否1是")
    private Boolean isDeleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "最新修改时间")
    private LocalDateTime lastUpdatedTime;


}
