package io.renren.common.utils;

/**
 * Redis所有Keys
 *
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
public class RedisKey {

    public static String getSysConfigKey(String key) {
        return "sys:config:" + key;
    }
}
