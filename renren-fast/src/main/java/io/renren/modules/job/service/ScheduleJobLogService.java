package io.renren.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * @author 张乃川
 * @date 2021/11/24 11:29
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
