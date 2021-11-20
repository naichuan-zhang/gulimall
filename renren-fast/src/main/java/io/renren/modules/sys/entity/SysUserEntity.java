package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 *
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
@Data
@TableName("sys_user")
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 8926237937910968610L;

    // TODO
    @TableId
    private Long userId;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Integer status;

    private List<Long> roleIdList;

    private Long createUserId;

    private Date createTime;
}
