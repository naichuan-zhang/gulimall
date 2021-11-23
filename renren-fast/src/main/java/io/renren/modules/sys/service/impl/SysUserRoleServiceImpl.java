package io.renren.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.MapUtils;
import io.renren.modules.sys.dao.SysUserRoleDao;
import io.renren.modules.sys.entity.SysUserRoleEntity;
import io.renren.modules.sys.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张乃川
 * @date 2021/11/23 15:54
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        // 先删除用户与角色的关系
        this.removeByMap(new MapUtils().put("user_id", userId));
        if (roleIdList == null || roleIdList.size() == 0) {
            return;
        }
        // 保存用户与角色的关系
        for (Long roleId : roleIdList) {
            SysUserRoleEntity entity = new SysUserRoleEntity();
            entity.setUserId(userId);
            entity.setRoleId(roleId);
            this.save(entity);
        }
    }

    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return baseMapper.queryRoleIdList(userId);
    }

    @Override
    public int deleteBatch(Long[] roleIds) {
        return baseMapper.deleteBatch(roleIds);
    }
}
