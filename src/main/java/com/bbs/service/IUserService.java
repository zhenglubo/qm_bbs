package com.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bbs.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bbs.dto.user.ManagerUserPageQueryDto;
import com.bbs.dto.user.UserLoginDto;
import com.bbs.dto.user.UserRegisterDto;
import com.bbs.result.DataResult;
import com.bbs.vo.user.ManagerUserPageQueryVo;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
public interface IUserService extends IService<User> {

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    Boolean selectByUserName(String username);

    /**
     * 新增用户
     * @param dto
     * @return
     */
    DataResult<String> insertUser(UserRegisterDto dto);

    /**
     * 用户登录dto
     * @param userLoginDto
     * @return
     */
    DataResult<User> userLogin(UserLoginDto userLoginDto);

    /**
     * 管理端-今日新增用户数量
     * @param begin
     * @param end
     * @return
     */
    int countTodayAddNum(LocalDateTime begin, LocalDateTime end);

    /**
     * 管理端-分页查询用户
     * @param dto
     * @return
     */
    DataResult<IPage<ManagerUserPageQueryVo>> managerPageQueryUser(ManagerUserPageQueryDto dto);

    /**
     * 管理端删除用户
     * @param userId
     * @return
     */
    DataResult<String> managerDeleteUser(Long userId);
}
