package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
}
