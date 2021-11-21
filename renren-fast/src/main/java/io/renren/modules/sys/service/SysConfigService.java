package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SysConfigEntity;

import java.util.Map;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
public interface SysConfigService extends IService<SysConfigEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveConfig(SysConfigEntity config);

    void updateValueByKey(String key, String value);

    void update(SysConfigEntity config);

    void deleteBatch(Long[] ids);

    String getValue(String key);

    public <T> T getConfigObject(String key, Class<T> clazz);
}
