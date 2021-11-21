package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户与角色对应关系
 *
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
@Data
@TableName("sys_user_role")
public class SysUserRoleEntity implements Serializable {
    private static final long serialVersionUID = 8802724189334049542L;

    @TableId
    private Long id;

    private Long userId;
    private Long roleId;
}
