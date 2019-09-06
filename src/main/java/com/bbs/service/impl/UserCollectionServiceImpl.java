package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.UserCollection;
import com.bbs.dto.usercollection.AddCollectionDto;
import com.bbs.dto.usercollection.PageQueryCollectionDto;
import com.bbs.mapper.UserCollectionMapper;
import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.service.IUserCollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbs.vo.usercollection.UserCollectionVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 用户收藏 服务实现类
 * </p>
 *
 * @author zlb
 * @since 2019-09-06
 */
@Service
public class UserCollectionServiceImpl extends ServiceImpl<UserCollectionMapper, UserCollection> implements IUserCollectionService {

    @Autowired
    private UserCollectionMapper collectionMapper;

    /**
     * 添加收藏
     * @param dto
     * @return
     */
    @Override
    public DataResult<String> addCollection(AddCollectionDto dto) {
        QueryWrapper<UserCollection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",dto.getUserId());
        queryWrapper.eq("is_deleted",false);
        queryWrapper.eq("topic_id",dto.getCollectionId());
        queryWrapper.or().eq("theme_id",dto.getCollectionId());
        List<UserCollection> list = collectionMapper.selectList(queryWrapper);
        if(CollectionUtils.isEmpty(list)){
            UserCollection one = new UserCollection();
            one.setUserId(dto.getUserId());
            if("topic".equalsIgnoreCase(dto.getType())){
                one.setTopicId(dto.getCollectionId());
            }else {
                one.setThemeId(dto.getCollectionId());
            }
            int result = collectionMapper.insert(one);
            return result>0?DataResultBuild.success("收藏成功"):DataResultBuild.fail("收藏失败");
        }
        return DataResultBuild.fail("您已收藏过");
    }

    /**
     * 分页查询我的收藏
     * @param dto
     * @return
     */
    @Override
    public DataResult<IPage<UserCollectionVo>> pageQueryCollection(PageQueryCollectionDto dto) {
        Page<UserCollectionVo> page =new Page<>(dto.getCurrent(),dto.getPageSize());
        List<UserCollectionVo> voList =  collectionMapper.pageQueryCollection(page,dto.getUserId());
        page.setRecords(voList);
        return DataResultBuild.success(page);
    }
}
