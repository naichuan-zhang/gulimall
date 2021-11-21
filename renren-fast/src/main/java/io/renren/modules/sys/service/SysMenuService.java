package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.sys.entity.SysMenuEntity;

import java.util.List;

/**
 * @author Naichuan Zhang
 * @since 11/21/2021
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    /**
     * 根据父菜单，查询子菜单
     * @param parentId
     * @param menuIdList
     * @return
     */
    List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId
     * @return
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     * @return
     */
    List<SysMenuEntity> queryNotButtonList();

    /**
     * 获取用户菜单列表
     * @param userId
     * @return
     */
    List<SysMenuEntity> getUserMenuList(Long userId);

    void delete(Long menuId);
}
