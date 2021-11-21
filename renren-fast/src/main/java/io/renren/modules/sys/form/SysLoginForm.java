package io.renren.modules.sys.form;

import lombok.Data;

/**
 * 登录菜单
 *
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
@Data
public class SysLoginForm {

    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
