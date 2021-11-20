package io.renren.common.aspect;

import io.renren.common.exception.RRException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
@Aspect
@Configuration
public class RedisAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.redis.open: false}")
    private boolean open;

    @Around("execution(* io.renren.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        if (open) {
            try {
                result = pjp.proceed();
            } catch (Exception e) {
                logger.error("redis error", e);
                throw new RRException("Redis服务异常");
            }
        }
        return result;
    }
}
