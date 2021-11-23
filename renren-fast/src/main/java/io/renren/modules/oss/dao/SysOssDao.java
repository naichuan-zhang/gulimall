package io.renren.modules.oss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.oss.entity.SysOssEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 *
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {
}
