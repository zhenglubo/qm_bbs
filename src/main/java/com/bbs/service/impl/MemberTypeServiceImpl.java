package com.bbs.service.impl;

import com.bbs.domain.MemberType;
import com.bbs.mapper.MemberTypeMapper;
import com.bbs.service.IMemberTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员等级表 服务实现类
 * </p>
 *
 * @author zlb
 * @since 2019-09-02
 */
@Service
public class MemberTypeServiceImpl extends ServiceImpl<MemberTypeMapper, MemberType> implements IMemberTypeService {

}
