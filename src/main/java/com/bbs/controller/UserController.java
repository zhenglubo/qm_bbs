package com.bbs.controller;


import com.bbs.domain.User;
import com.bbs.dto.user.UserLoginDto;
import com.bbs.dto.user.UserRegisterDto;
import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
@Controller
@RequestMapping("/user")
@Api(tags = "用户controller")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("判断用户名是否存在")
    @GetMapping(value = "/exist/{username}")
    public DataResult<Boolean> existUsername(@PathVariable String username){
        return DataResultBuild.success(userService.selectByUserName(username));
    }

    @ApiOperation("用户注册")
    @PostMapping(value = "/register")
    public DataResult<String> userRegister(@RequestBody @Valid UserRegisterDto dto){
        return userService.insertUser(dto);
    }

    @ApiOperation("用户登录")
    @PostMapping(value = "/login")
    public DataResult<User> userLogin(@RequestBody UserLoginDto userLoginDto){
        return userService.userLogin(userLoginDto);
    }

    @ApiOperation("上传用户头像")
    @PostMapping(value = "uploadAvatar")
    public DataResult<String> uploadAvatar(@RequestParam MultipartFile file,@RequestParam Long id){
        return null;
    }
}
