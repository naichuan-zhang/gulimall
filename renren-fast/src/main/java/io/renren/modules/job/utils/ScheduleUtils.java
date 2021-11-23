package io.renren.modules.job.utils;

import io.renren.common.exception.RRException;
import io.renren.common.utils.Constant;
import io.renren.modules.job.entity.ScheduleJobEntity;
import org.quartz.*;

/**
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
public class ScheduleUtils {

    private static final String JOB_NAME = "TASK_";

    /**
     * 获取触发器key
     * @param jobId
     * @return
     */
    public static TriggerKey getTriggerKey(Long jobId) {
        return TriggerKey.triggerKey(JOB_NAME + jobId);
    }

    /**
     * 获取jobKey
     * @param jobId
     * @return
     */
    public static JobKey getJobKey(Long jobId) {
        return JobKey.jobKey(JOB_NAME + jobId);
    }

    /**
     * 获取表达式触发器
     * @param scheduler
     * @param jobId
     * @return
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, Long jobId) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("获取定时任务CronTrigger出现异常", e);
        }
    }

    /**
     * 创建定时任务
     * @param scheduler
     * @param scheduleJob
     */
    public static void createScheduleJob(Scheduler scheduler, ScheduleJobEntity scheduleJob) {
        try {
            // 构建job信息
            JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class).withIdentity(getJobKey(scheduleJob.getJobId())).build();

            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();

            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(scheduleJob.getJobId())).withSchedule(scheduleBuilder).build();

            // 放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(ScheduleJobEntity.JOB_PARAM_KEY, scheduleJob);
            scheduler.scheduleJob(jobDetail, trigger);

            // 暂停任务
            if (scheduleJob.getStatus() == Constant.ScheduleStatus.PAUSE.getValue()) {
                pauseJob(scheduler, scheduleJob.getJobId());
            }
        } catch (SchedulerException e) {
            throw new RRException("创建定时任务失败", e);
        }
    }

    /**
     * 更新定时任务
     * @param scheduler
     * @param scheduleJob
     */
    public static void updateScheduleJob(Scheduler scheduler, ScheduleJobEntity scheduleJob) {
        try {
            TriggerKey triggerKey = getTriggerKey(scheduleJob.getJobId());
            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();
            CronTrigger trigger = getCronTrigger(scheduler, scheduleJob.getJobId());
            // 按照新的cronExpression重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            // 参数
            trigger.getJobDataMap().put(ScheduleJobEntity.JOB_PARAM_KEY, scheduleJob);
            scheduler.rescheduleJob(triggerKey, trigger);
            // 暂停任务
            if (scheduleJob.getStatus() == Constant.ScheduleStatus.PAUSE.getValue()) {
                pauseJob(scheduler, scheduleJob.getJobId());
            }
        } catch (SchedulerException e) {
            throw new RRException("更新定时任务失败", e);
        }
    }

    /**
     * 立即执行定时任务
     * @param scheduler
     * @param scheduleJob
     */
    public static void run(Scheduler scheduler, ScheduleJobEntity scheduleJob) {
        try {
            JobDataMap dataMap = new JobDataMap();
            dataMap.put(ScheduleJobEntity.JOB_PARAM_KEY, scheduleJob);
            scheduler.triggerJob(getJobKey(scheduleJob.getJobId()), dataMap);
        } catch (SchedulerException e) {
            throw new RRException("立即执行定时任务失败", e);
        }
    }

    public static void pauseJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.pauseJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("暂停定时任务失败", e);
        }
    }

    /**
     * 恢复定时任务
     * @param scheduler
     * @param jobId
     */
    public static void resumeJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.resumeJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("恢复定时任务失败", e);
        }
    }

    /**
     * 删除定时任务
     * @param scheduler
     * @param jobId
     */
    public static void deleteScheduleJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.deleteJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new RRException("删除定时任务失败", e);
        }
    }
}
