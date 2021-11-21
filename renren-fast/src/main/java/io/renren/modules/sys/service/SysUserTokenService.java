package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.SysUserTokenEntity;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    R createToken(long userId);

    void logout(long userId);
}
