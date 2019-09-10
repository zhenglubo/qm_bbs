package com.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bbs.domain.Theme;
import com.bbs.domain.Topic;
import com.bbs.mapper.ThemeMapper;
import com.bbs.service.IThemeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlb
 * @since 2019-09-06
 */
@Service
public class ThemeServiceImpl extends ServiceImpl<ThemeMapper, Theme> implements IThemeService {

    @Autowired
    private ThemeMapper themeMapper;

    @Override
    public int countTodayAddNum(LocalDateTime begin,LocalDateTime end) {
        QueryWrapper<Theme> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("created_time", end);
        queryWrapper.ge("created_time", begin);
        Integer integer = themeMapper.selectCount(queryWrapper);
        return integer != null ? integer : 0;
    }
}
