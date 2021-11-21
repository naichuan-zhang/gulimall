package io.renren.modules.sys.redis;

import io.renren.common.utils.RedisKey;
import io.renren.common.utils.RedisUtils;
import io.renren.modules.sys.entity.SysConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 系统配置Redis
 *
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
@Component
public class SysConfigRedis {

    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysConfigEntity config) {
        if (config == null) {
            return;
        }
        String key = RedisKey.getSysConfigKey(config.getParamKey());
        redisUtils.set(key, config);
    }

    public void delete(String configKey) {
        String key = RedisKey.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }

    public SysConfigEntity get(String configKey) {
        String key = RedisKey.getSysConfigKey(configKey);
        return redisUtils.get(key, SysConfigEntity.class);
    }
}
