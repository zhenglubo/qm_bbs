package com.bbs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * 用户帖
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Topic对象", description="用户帖")
public class Topic extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "评论数")
    private Integer commentCount;

    @ApiModelProperty(value = "被收藏次数")
    private Integer collectCount;

    @ApiModelProperty(value = "浏览次数")
    private Integer viewCount;

    @ApiModelProperty(value = "是否置顶0否 1是")
    private Boolean top;

    @ApiModelProperty(value = "是否为热帖0否 1是")
    private Boolean good;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "微信号")
    private String wechat;

    @ApiModelProperty(value = "qq号码")
    private String qq;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "最新修改时间")
    private LocalDateTime lastUpdatedTime;

    @ApiModelProperty(value = "是否被删除0否1是")
    private Boolean isDeleted;


}
