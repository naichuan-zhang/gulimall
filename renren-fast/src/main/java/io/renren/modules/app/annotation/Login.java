package io.renren.modules.app.annotation;

import java.lang.annotation.*;

/**
 * app登录校验
 *
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
