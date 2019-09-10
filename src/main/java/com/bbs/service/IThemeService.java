package com.bbs.service;

import com.bbs.domain.Theme;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zlb
 * @since 2019-09-06
 */
public interface IThemeService extends IService<Theme> {

    /**
     * 今日新增主题数量
     * @param begin
     * @param end
     * @return
     */
    int countTodayAddNum(LocalDateTime begin,LocalDateTime end);
}
