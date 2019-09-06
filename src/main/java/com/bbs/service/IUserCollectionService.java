package com.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.domain.UserCollection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bbs.dto.usercollection.AddCollectionDto;
import com.bbs.dto.usercollection.PageQueryCollectionDto;
import com.bbs.result.DataResult;
import com.bbs.vo.usercollection.UserCollectionVo;

/**
 * <p>
 * 用户收藏 服务类
 * </p>
 *
 * @author zlb
 * @since 2019-09-06
 */
public interface IUserCollectionService extends IService<UserCollection> {

    /**
     * 新增收藏(帖子（topic）或主题（theme)
     * @param dto
     * @return
     */
    DataResult<String> addCollection(AddCollectionDto dto);

    /**
     * 分页查询我的收藏
     * @param dto
     * @return
     */
    DataResult<IPage<UserCollectionVo>> pageQueryCollection(PageQueryCollectionDto dto);
}
