package io.renren.common.annotation;

import java.lang.annotation.*;

/**
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
