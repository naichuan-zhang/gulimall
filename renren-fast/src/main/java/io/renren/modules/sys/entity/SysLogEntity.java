package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志
 *
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
@Data
@TableName("sys_log")
public class SysLogEntity implements Serializable {
    private static final long serialVersionUID = 2435079046133697968L;

    @TableId
    private Long id;

    private String username;
    private String operation;
    private String method;
    private String params;
    private Long time;
    private String ip;
    private Date createDate;
}
