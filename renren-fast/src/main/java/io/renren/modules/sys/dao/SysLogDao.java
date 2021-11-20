package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 *
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
}
