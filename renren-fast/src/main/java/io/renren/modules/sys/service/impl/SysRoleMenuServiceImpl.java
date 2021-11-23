package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.sys.dao.SysRoleMenuDao;
import io.renren.modules.sys.entity.SysRoleMenuEntity;
import io.renren.modules.sys.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张乃川
 * @date 2021/11/23 15:41
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        // 先删除角色与菜单关系
        deleteBatch(new Long[]{roleId});
        if (menuIdList.size() == 0) {
            return;
        }
        // 保存角色与菜单关系
        for (Long menuId : menuIdList) {
            SysRoleMenuEntity entity = new SysRoleMenuEntity();
            entity.setMenuId(menuId);
            entity.setRoleId(roleId);
            this.save(entity);
        }
    }

    @Override
    public List<Long> queryMenuIdList(Long roleId) {
        return baseMapper.queryMenuIdList(roleId);
    }

    @Override
    public int deleteBatch(Long[] roleIds) {
        return baseMapper.deleteBatch(roleIds);
    }
}
