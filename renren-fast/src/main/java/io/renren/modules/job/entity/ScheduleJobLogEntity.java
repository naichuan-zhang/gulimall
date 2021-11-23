package io.renren.modules.job.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
@Data
@TableName("schedule_job_log")
public class ScheduleJobLogEntity implements Serializable {
    private static final long serialVersionUID = -6121491967538143199L;

    @TableId
    private Long logId;

    private Long jobId;

    private String beanName;

    private String params;

    /**
     * 任务状态    0：成功    1：失败
     */
    private Integer status;

    private String error;

    private Integer times;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
