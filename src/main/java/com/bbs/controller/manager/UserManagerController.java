package com.bbs.controller.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.dto.user.ManagerUserPageQueryDto;
import com.bbs.result.DataResult;
import com.bbs.service.IUserService;
import com.bbs.vo.user.ManagerUserPageQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 用户管理
 * @author: zhenglubo
 * @create: 2019-09-10 17:33
 **/

@Api(tags = "管理端-用户")
@RestController
@RequestMapping("/admin/user")
public class UserManagerController {

    @Autowired
    private IUserService userService;

    @ApiOperation("分页查询用户")
    @PostMapping(value = "/managerPageQueryUser")
    public DataResult<IPage<ManagerUserPageQueryVo>> managerPageQueryUser(@RequestBody ManagerUserPageQueryDto dto){
        return userService.managerPageQueryUser(dto);
    }

    @ApiImplicitParam(name = "userId",value = "用户id",defaultValue = "4",required = true)
    @ApiOperation("删除用户")
    @GetMapping(value = "/deleteUser")
    public DataResult<String> deleteUser(@RequestParam Long userId){
        return userService.managerDeleteUser(userId);
    }
}
