package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {

    /**
     * 查询用户创建的角色ID列表
     * @param createUserId
     * @return
     */
    List<Long> queryRoleIdList(Long createUserId);
}
