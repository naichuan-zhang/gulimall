package io.renren.common.validator;

import io.renren.common.exception.RRException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 *
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
public abstract class Assert {

    public static void isBlank(String str, String msg) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(msg);
        }
    }

    public static void isNull(Object obj, String msg) {
        if (obj == null) {
            throw new RRException(msg);
        }
    }
}
