package io.renren.modules.sys.controller;

import io.renren.common.utils.R;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.form.SysLoginForm;
import io.renren.modules.sys.service.SysCaptchaService;
import io.renren.modules.sys.service.SysUserService;
import io.renren.modules.sys.service.SysUserTokenService;
import lombok.SneakyThrows;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @author 张乃川
 * @date 2021/11/23 16:24
 */
@RestController
public class SysLoginController extends AbstractController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    @Autowired
    private SysCaptchaService sysCaptchaService;

    @SneakyThrows
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 获取图片验证码
        BufferedImage captcha = sysCaptchaService.getCaptcha(uuid);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(captcha, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录 
     * @author 张乃川
     * @date 2021/11/23 16:31
     * @param 
     */
    @PostMapping("/sys/login")
    public Map<String, Object> login(@RequestBody SysLoginForm form) {
        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            return R.error("验证码不正确");
        }
        // 用户信息
        SysUserEntity user = sysUserService.queryByUserName(form.getUsername());
        // 帐号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return R.error("帐号或密码不正确");
        }
        // 帐号锁定
        if (user.getStatus() == 0) {
            return R.error("帐号锁定");
        }
        // 生成token，并保存到数据库
        return sysUserTokenService.createToken(user.getUserId());
    }
    
    /**
     * 登出
     * @author 张乃川
     * @date 2021/11/23 16:31
     * @param 
     */
    @PostMapping("/sys/logout")
    public R logout() {
        sysUserTokenService.logout(this.getUserId());
        return R.ok();
    }
}
