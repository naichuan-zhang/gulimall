package io.renren.modules.sys.form;

import lombok.Data;

/**
 * 密码表单
 *
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
@Data
public class PasswordForm {

    private String password;
    private String newPassword;
}
