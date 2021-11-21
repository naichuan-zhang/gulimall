package io.renren.common.exception;

import cn.hutool.http.HttpStatus;
import io.renren.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
@RestControllerAdvice
public class RRExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RRExceptionHandler.class);

    @ExceptionHandler(RRException.class)
    public R handleRRException(RRException e) {
        return R.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public R handleNoHandlerFoundException(NoHandlerFoundException e) {
        logger.error(e.getMessage(), e);
        return R.error(HttpStatus.HTTP_NOT_FOUND, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return R.error("数据库中已存在该记录");
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return R.error();
    }
}
