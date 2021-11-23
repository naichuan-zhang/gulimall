package io.renren.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.job.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {
}
