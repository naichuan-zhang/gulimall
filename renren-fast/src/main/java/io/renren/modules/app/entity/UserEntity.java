package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
@Data
@TableName("tb_user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -6878006601992935127L;

    @TableId
    private Long userId;
    private String username;
    private String mobile;
    private String password;
    private Date createTime;
}
