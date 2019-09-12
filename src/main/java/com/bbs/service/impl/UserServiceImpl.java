package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.User;
import com.bbs.dto.user.ManagerUserPageQueryDto;
import com.bbs.dto.user.UserLoginDto;
import com.bbs.dto.user.UserRegisterDto;
import com.bbs.exception.ApiAssert;
import com.bbs.exception.BizRuntimeException;
import com.bbs.mapper.UserMapper;
import com.bbs.result.DataResult;
import com.bbs.result.DataResultBuild;
import com.bbs.service.ISystemConfigService;
import com.bbs.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbs.uitls.CookieUtil;
import com.bbs.uitls.SessionUtil;
import com.bbs.uitls.StringUtil;
import com.bbs.vo.user.ManagerUserPageQueryVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private SessionUtil sessionUtil;

    /**
     * 判断用户名是否存在
     *
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
     *
     * @param dto
     * @return
     */
    @Override
    public DataResult<String> insertUser(UserRegisterDto dto) {
        ApiAssert.notEmpty(dto.getUsername(), "用户名为空");
        ApiAssert.notTrue(selectByUserName(dto.getUsername()), "该用户名已经存在");
        ApiAssert.isTrue(StringUtil.check(dto.getUsername(), StringUtil.USERNAMEREGEX), "用户名只能为a-z,A-Z,0-9组合且2-16位");
        ApiAssert.notEmpty(dto.getEmail(), "邮箱不能为空");
        //ApiAssert.notTrue(StringUtil.check(dto.getEmail(), StringUtil.EMAILREGEX), "请输入正确的邮箱地址");
        ApiAssert.notTrue(selectByEmail(dto.getEmail()) != null, "该邮箱已被注册，请更换新的邮箱");
        ApiAssert.notEmpty(dto.getVerificationCode(), "验证码不能为空");
        ApiAssert.notEmpty(dto.getPassword(), "密码不能为空");
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
        sessionUtil.doUserStorage(user);
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
        ApiAssert.notEmpty(userLoginDto.getPassword(), "密码不能为空");
        ApiAssert.notEmpty(userLoginDto.getUsername(), "用户名不能为空");
        User user = this.selectByUserNameAndPassword(userLoginDto.getUsername(), userLoginDto.getPassword());
        ApiAssert.notNull(user, "用户名或密码错误");
        sessionUtil.doUserStorage(user);
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
        queryWrapper.eq("email", email);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User selectByToken(String token) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("token", token);
        return userMapper.selectOne(queryWrapper);
    }

    /**
     * 管理端-今日新增用户数量
     *
     * @param begin
     * @param end
     * @return
     */
    @Override
    public int countTodayAddNum(LocalDateTime begin, LocalDateTime end) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("created_time", begin);
        queryWrapper.le("created_time", end);
        Integer count = userMapper.selectCount(queryWrapper);
        return count != null ? count : 0;
    }

    /**
     * 管理端-分页查询用户
     *
     * @param dto
     * @return
     */
    @Override
    public DataResult<IPage<ManagerUserPageQueryVo>> managerPageQueryUser(ManagerUserPageQueryDto dto) {
        Page<ManagerUserPageQueryVo> page = new Page<>(dto.getCurrent(), dto.getPageSize());
        page = userMapper.managerPageQueryUser(page, dto);
        return DataResultBuild.success(page);
    }

    /**
     * 管理端-删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public DataResult<String> managerDeleteUser(Long userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        queryWrapper.eq("is_deleted", false);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new BizRuntimeException("该用户不存在");
        }
        int result = userMapper.deleteById(userId);
        return result > 0 ? DataResultBuild.success("用户删除成功") : DataResultBuild.fail("用户删除失败");
    }


}
