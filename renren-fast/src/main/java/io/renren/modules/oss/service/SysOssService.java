package io.renren.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
public interface SysOssService extends IService<SysOssEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
