package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色与菜单对应关系
 *
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
@Data
@TableName("sys_role_menu")
public class SysRoleMenuEntity implements Serializable {
    private static final long serialVersionUID = 3726534797018589456L;

    @TableId
    private Long id;

    private Long roleId;
    private Long menuId;
}
