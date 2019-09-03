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
 * 帖子评论表
 * </p>
 *
 * @author zlb
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Comments对象", description="帖子评论表")
public class Comments extends Model {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "帖子id")
    private Long topicId;

    @ApiModelProperty(value = "评论的内容")
    private String content;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "点赞数")
    private Integer likeNum;

    @ApiModelProperty(value = "上传图片列表")
    private String uploadImgIds;

    @ApiModelProperty(value = "是否被禁言0否1是")
    private Boolean isEnabled;

    @ApiModelProperty(value = "是否被删除0否1是")
    private Boolean isDeleted;

    @ApiModelProperty(value = "评论时间")
    private LocalDateTime createdTime;


}
