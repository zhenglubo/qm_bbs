package com.bbs.service;

import com.bbs.domain.SystemConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 系统配置表 服务类
 * </p>
 *
 * @author zlb
 * @since 2019-09-11
 */
public interface ISystemConfigService extends IService<SystemConfig> {

    /**
     * 查询所有配置
     * @return
     */
    Map selectAll();
}
