package io.renren.common.validator.group;

import javax.validation.GroupSequence;

/**
 * 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 *
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {
}
