package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bbs.domain.User;
import com.bbs.dto.user.UserLoginDto;
import com.bbs.dto.user.UserRegisterDto;
import com.bbs.exception.ApiAssert;
import com.bbs.mapper.UserMapper;
import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbs.uitls.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    @Override
    public Boolean selectByUserName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        return user != null;
    }

    /**
     * 用户注册
     * @param dto
     * @return
     */
    @Override
    public DataResult<String> insertUser(UserRegisterDto dto) {
        ApiAssert.isEmpty(dto.getUsername(), "用户名为空");
        ApiAssert.isTrue(selectByUserName(dto.getUsername()), "该用户名已经存在");
        ApiAssert.isTrue(StringUtil.check(dto.getUsername(), StringUtil.USERNAMEREGEX), "用户名只能为a-z,A-Z,0-9组合且2-16位");
        ApiAssert.isEmpty(dto.getEmail(), "邮箱不能为空");
        ApiAssert.isTrue(StringUtil.check(dto.getEmail(), StringUtil.EMAILREGEX), "请输入正确的邮箱地址");
        ApiAssert.isTrue(selectByEmail(dto.getEmail()) != null, "该邮箱已被注册，请更换新的邮箱");
        ApiAssert.isEmpty(dto.getVerificationCode(), "验证码不能为空");
        ApiAssert.isEmpty(dto.getPassword(), "密码不能为空");
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setToken(UUID.randomUUID().toString());
        user.setScore(0);
        user.setCreatedTime(LocalDateTime.now());
        user.setActive(true);
        user.setIsDeleted(false);
        int result = userMapper.insert(user);
        return result > 0 ? DataResultBuild.success("用户注册成功") : DataResultBuild.fail("用户注册失败");
    }

    /**
     * 用户登录
     *
     * @param userLoginDto
     * @return
     */
    @Override
    public DataResult<User> userLogin(UserLoginDto userLoginDto) {
        ApiAssert.isEmpty(userLoginDto.getPassword(), "密码不能为空");
        ApiAssert.isEmpty(userLoginDto.getUsername(), "用户名不能为空");
        User user = this.selectByUserNameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());
        ApiAssert.notNull(user, "用户名或密码错误");
        return DataResultBuild.success(user);
    }

    private User selectByUserNameAndPassword(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        return userMapper.selectOne(queryWrapper);
    }

    private User selectByEmail(String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("email", email);
        return userMapper.selectOne(queryWrapper);
    }
}
