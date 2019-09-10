package com.bbs.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bbs.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbs.dto.user.ManagerUserPageQueryDto;
import com.bbs.vo.user.ManagerUserPageQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 管理端-分页查询用户
     * @param page
     * @param dto
     * @return
     */
    Page<ManagerUserPageQueryVo> managerPageQueryUser(@Param("page") Page<ManagerUserPageQueryVo> page, @Param("dto") ManagerUserPageQueryDto dto);
}
