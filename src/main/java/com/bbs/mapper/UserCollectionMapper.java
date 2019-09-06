package com.bbs.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.UserCollection;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbs.vo.usercollection.UserCollectionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户收藏 Mapper 接口
 * </p>
 *
 * @author zlb
 * @since 2019-09-06
 */
public interface UserCollectionMapper extends BaseMapper<UserCollection> {

    /**
     * 分页查询我的收藏
     * @param page
     * @param userId
     * @return
     */
    List<UserCollectionVo> pageQueryCollection(@Param(value = "page") Page<UserCollectionVo> page, @Param(value = "userId") Long userId);
}
