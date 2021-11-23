package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import io.renren.common.exception.RRException;
import io.renren.common.utils.DateUtils;
import io.renren.modules.sys.dao.SysCaptchaDao;
import io.renren.modules.sys.entity.SysCaptchaEntity;
import io.renren.modules.sys.service.SysCaptchaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * @author 张乃川
 * @date 2021/11/23 15:05
 */
@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaDao, SysCaptchaEntity> implements SysCaptchaService {

    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if (StringUtils.isBlank(uuid)) {
            throw new RRException("uuid不能为空");
        }
        // 生成文字验证码
        String code = producer.createText();
        SysCaptchaEntity captcha = new SysCaptchaEntity();
        captcha.setUuid(uuid);
        captcha.setCode(code);
        // 5分钟后过期
        captcha.setExpireTime(DateUtils.addDateMinutes(new Date(), 5));
        this.save(captcha);
        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        SysCaptchaEntity captcha = this.getOne(new QueryWrapper<SysCaptchaEntity>().eq("uuid", uuid));
        if (captcha == null) {
            return false;
        }
        // 删除验证码
        this.removeById(uuid);
        if (captcha.getCode().equalsIgnoreCase(code) && captcha.getExpireTime().getTime() >= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }
}
