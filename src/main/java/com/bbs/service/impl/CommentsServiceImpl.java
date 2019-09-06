package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.injector.methods.additional.LogicDeleteByIdWithFill;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.Comments;
import com.bbs.domain.Images;
import com.bbs.dto.comment.AddCommentDto;
import com.bbs.dto.comment.CommentPageQueryDto;
import com.bbs.exception.BizRuntimeException;
import com.bbs.mapper.CommentsMapper;
import com.bbs.mapper.ImagesMapper;
import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbs.uitls.OssUtil;
import com.bbs.uitls.TimeUtil;
import com.bbs.vo.comments.CommentsVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 帖子评论表 服务实现类
 * </p>
 *
 * @author zlb
 * @since 2019-09-03
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private ImagesMapper imagesMapper;

    @Autowired
    private OssUtil ossUtil;

    /**
     * 分页查询评论
     *
     * @param dto
     * @return
     */
    @Override
    public DataResult<IPage<CommentsVo>> pageQuery(CommentPageQueryDto dto) {
        Page<CommentsVo> page = new Page<>(dto.getCurrent(), dto.getPageSize());
        List<CommentsVo> commentsVoList = commentsMapper.selectByTopicId(page, dto.getTopicId());
        if (!CollectionUtils.isEmpty(commentsVoList)) {
            commentsVoList.stream().forEach(record -> record.setCommentTimeDiff(TimeUtil.calculateTimeDiff(record.getCommentPublishHour())));
        }
        page.setRecords(commentsVoList);
        return DataResultBuild.success(page);
    }

    /**
     * 禁用评论
     *
     * @param commentId
     * @return
     */
    @Override
    public DataResult<String> disableComment(Long commentId) {
        Comments comments = commentsMapper.selectById(commentId);
        if (comments == null) {
            return DataResultBuild.fail("该评论不存在");
        }
        comments.setIsEnabled(true);
        int result = commentsMapper.updateById(comments);
        return result > 0 ? DataResultBuild.success("成功") : DataResultBuild.fail("失败");
    }

    /**
     * 新增评论
     *
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public DataResult<String> addComment(AddCommentDto dto) {
        Comments comments = new Comments();
        BeanUtils.copyProperties(dto, comments);
        MultipartFile[] files = dto.getMultipartFiles();
        if (files != null && files.length > 0) {
            //图片上传
            Images images = new Images();
            String downloadUrl;
            Long commentsId = comments.getId();
            for (MultipartFile file : files) {
                downloadUrl = ossUtil.uploadFile(file, "comments", dto.getUserId().toString());
                images.setCommentId(commentsId);
                images.setUserId(dto.getUserId());
                images.setDownloadUrl(downloadUrl);
                imagesMapper.insert(images);
            }
        }
        return DataResultBuild.success("新增成功");
    }

    /**
     * 删除评论（软删除）
     *
     * @param commentIds
     * @return
     */
    @Override
    public DataResult<String> deletedComments(String commentIds) {
        List<String> idList = Arrays.asList(commentIds.split(","));
        UpdateWrapper<Comments> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("id", idList);
        int result = commentsMapper.update(null, updateWrapper);
        return result > 0 ? DataResultBuild.success("删除成功") : DataResultBuild.fail("删除失败");
    }
}
