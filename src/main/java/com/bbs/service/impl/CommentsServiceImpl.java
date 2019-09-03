package com.bbs.service.impl;

import com.bbs.domain.Comments;
import com.bbs.mapper.CommentsMapper;
import com.bbs.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
