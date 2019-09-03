package com.bbs.service.impl;

import com.bbs.domain.Images;
import com.bbs.mapper.ImagesMapper;
import com.bbs.service.IImagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图片表 服务实现类
 * </p>
 *
 * @author zlb
 * @since 2019-09-03
 */
@Service
public class ImagesServiceImpl extends ServiceImpl<ImagesMapper, Images> implements IImagesService {

}
