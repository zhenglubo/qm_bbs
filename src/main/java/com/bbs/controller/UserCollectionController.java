package com.bbs.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.dto.usercollection.AddCollectionDto;
import com.bbs.dto.usercollection.PageQueryCollectionDto;
import com.bbs.result.DataResult;
import com.bbs.service.IUserCollectionService;
import com.bbs.vo.usercollection.UserCollectionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 用户收藏 前端控制器
 * </p>
 *
 * @author zlb
 * @since 2019-09-06
 */
@RestController
@RequestMapping("/user-collection")
@Api(tags = "用户收藏")
public class UserCollectionController {

    @Autowired
    private IUserCollectionService userCollectionService;

    @ApiOperation("新增收藏(帖子（topic）或主题（theme)")
    @PostMapping(value = "/addCollection")
    public DataResult<String> addCollection(@RequestBody @Valid AddCollectionDto dto) {
        return userCollectionService.addCollection(dto);
    }

    @ApiOperation("分页查询我的收藏")
    @PostMapping(value = "/pageQueryCollection")
    public DataResult<IPage<UserCollectionVo>> pageQueyCollection(@RequestBody @Valid PageQueryCollectionDto dto) {
        return userCollectionService.pageQueryCollection(dto);
    }
}
