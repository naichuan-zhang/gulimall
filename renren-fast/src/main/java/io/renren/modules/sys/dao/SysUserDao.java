package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    /**
     * 查询用户的所有权限
     * @param userId
     * @return
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     * @param userId
     * @return
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     * @param username
     * @return
     */
    SysUserEntity queryByUsername(String username);
}
