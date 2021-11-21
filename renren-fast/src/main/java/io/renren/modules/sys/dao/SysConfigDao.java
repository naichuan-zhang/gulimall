package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
@Mapper
public interface SysConfigDao extends BaseMapper<SysConfigEntity> {

    /**
     * 根据key，查询value
     * @param paramKey
     * @return
     */
    SysConfigEntity queryByKey(String paramKey);

    /**
     * 根据key，更新value
     * @param paramKey
     * @param paramValue
     * @return
     */
    int updateValueByKey(@Param("paramKey") String paramKey, @Param("paramValue") String paramValue);
}
