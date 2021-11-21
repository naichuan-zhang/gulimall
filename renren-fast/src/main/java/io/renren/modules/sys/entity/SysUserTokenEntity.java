package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户Token
 *
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
@Data
@TableName("sys_user_token")
public class SysUserTokenEntity implements Serializable {
    private static final long serialVersionUID = 7783284527178579506L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.INPUT)
    private Long userId;

    private String token;
    private Date expireTime;
    private Date updateTime;
}
