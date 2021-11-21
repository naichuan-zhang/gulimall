package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.sys.entity.SysRoleMenuEntity;

import java.util.List;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {

    void saveOrUpdate(Long roleId, List<Long> menuIdList);

    List<Long> queryMenuIdList(Long roleId);

    int deleteBatch(Long[] roleIds);
}
