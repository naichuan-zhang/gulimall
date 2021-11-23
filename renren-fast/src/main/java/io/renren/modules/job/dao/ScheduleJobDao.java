package io.renren.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.job.entity.ScheduleJobEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
@Mapper
public interface ScheduleJobDao extends BaseMapper<ScheduleJobEntity> {

    /**
     * 批量更新状态
     * @param map
     * @return
     */
    int updateBatch(Map<String, Object> map);
}
