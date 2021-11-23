package io.renren.common.utils;

import java.util.HashMap;

/**
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
public class MapUtils extends HashMap<String, Object> {

    @Override
    public HashMap<String, Object> put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
