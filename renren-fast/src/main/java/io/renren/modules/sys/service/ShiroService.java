package io.renren.modules.sys.service;

import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.entity.SysUserTokenEntity;

import java.util.Set;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
public interface ShiroService {

    /**
     * 获取用户权限列表
     * @param userId
     * @return
     */
    Set<String> getUserPermissions(long userId);

    SysUserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     * @return
     */
    SysUserEntity queryUser(Long userId);
}
