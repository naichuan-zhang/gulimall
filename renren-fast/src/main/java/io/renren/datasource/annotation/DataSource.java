package io.renren.datasource.annotation;

import java.lang.annotation.*;

/**
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {

    String value() default "";
}
