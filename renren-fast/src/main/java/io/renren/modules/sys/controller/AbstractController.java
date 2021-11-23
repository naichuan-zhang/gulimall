package io.renren.modules.sys.controller;

import io.renren.common.utils.ShiroUtils;
import io.renren.modules.sys.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * controller公共组件
 *
 * @author 张乃川
 * @date 2021/11/23 16:14
 */
public abstract class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser() {
        return ShiroUtils.getUserEntity();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }
}
