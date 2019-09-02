package com.bbs.mapper;

import com.bbs.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
