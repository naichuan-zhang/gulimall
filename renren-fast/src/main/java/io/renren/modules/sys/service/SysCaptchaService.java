package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.sys.entity.SysCaptchaEntity;

import java.awt.image.BufferedImage;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
public interface SysCaptchaService extends IService<SysCaptchaEntity> {

    /**
     * 获取图片验证码
     * @param uuid
     * @return
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码校验
     * @param uuid uuid
     * @param code 验证码
     * @return 是否成功
     */
    boolean validate(String uuid, String code);
}
