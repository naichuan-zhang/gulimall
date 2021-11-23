package io.renren.modules.job.utils;

import io.renren.common.utils.SpringContextUtils;
import io.renren.modules.job.entity.ScheduleJobEntity;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时任务
 *
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
public class ScheduleJob extends QuartzJobBean {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        ScheduleJobEntity scheduleJob = (ScheduleJobEntity) context.getMergedJobDataMap()
                .get(ScheduleJobEntity.JOB_PARAM_KEY);
        // 获取spring bean
        // TODO ...
    }
}
