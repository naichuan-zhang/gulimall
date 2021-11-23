package io.renren.modules.oss.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传
 *
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
@Data
@TableName("sys_oss")
public class SysOssEntity implements Serializable {
    private static final long serialVersionUID = -182531079179559378L;

    @TableId
    private Long id;
    private String url;
    private Date createDate;
}
