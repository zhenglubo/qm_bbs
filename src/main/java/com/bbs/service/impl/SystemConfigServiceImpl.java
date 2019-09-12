package com.bbs.service.impl;

import com.bbs.domain.SystemConfig;
import com.bbs.mapper.SystemConfigMapper;
import com.bbs.service.ISystemConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author zlb
 * @since 2019-09-11
 */
@Service
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements ISystemConfigService {

    @Autowired
    private SystemConfigMapper systemConfigMapper;
    private static Map SYSTEM_CONFIG;

    @Override
    public Map selectAll() {
        List<SystemConfig> configList = systemConfigMapper.selectList(null);
        SYSTEM_CONFIG = configList.stream().filter(systemConfig -> systemConfig.getPid() != 0).collect(Collectors.toMap(SystemConfig::getSystemKey,SystemConfig::getSystemValue));
        return SYSTEM_CONFIG;
    }
}
