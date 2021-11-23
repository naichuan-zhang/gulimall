package io.renren.modules.sys.controller;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.Constant;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.entity.SysRoleEntity;
import io.renren.modules.sys.service.SysRoleMenuService;
import io.renren.modules.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author Naichuan Zhang
 * @since 11/23/2021
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 角色列表
     * @param params
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("sys:role:list")
    public R list(@RequestParam Map<String, Object> params) {
        // 如果不是超级管理员，则只查询自己创建的角色列表
        if (this.getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", this.getUserId());
        }
        PageUtils page = sysRoleService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 角色列表
     * @return
     */
    @GetMapping("/select")
    @RequiresPermissions("sys:role:select")
    public R select() {
        Map<String, Object> map = new HashMap<>();
        // 如果不是超级管理员，则只查询自己创建的角色列表
        if (this.getUserId() != Constant.SUPER_ADMIN) {
            map.put("create_user_id", this.getUserId());
        }
        List<SysRoleEntity> list = sysRoleService.listByMap(map);
        return R.ok().put("list", list);
    }

    /**
     * 角色信息
     * @return
     */
    @GetMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public R info(@PathVariable("roleId") Long roleId) {
        SysRoleEntity role = sysRoleService.getById(roleId);
        // 查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        role.setMenuIdList(menuIdList);
        return R.ok().put("role", role);
    }

    /**
     * 保存角色
     * @param role
     * @return
     */
    @SysLog("保存角色")
    @PostMapping("/save")
    @RequiresPermissions("sys:role:save")
    public R save(@RequestBody SysRoleEntity role) {
        ValidatorUtils.validateEntity(role);
        role.setCreateUserId(this.getUserId());
        return R.ok();
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @SysLog("修改角色")
    @PostMapping("/update")
    @RequiresPermissions("sys:role:update")
    public R update(@RequestBody SysRoleEntity role) {
        ValidatorUtils.validateEntity(role);
        role.setCreateUserId(this.getUserId());
        sysRoleService.update(role);
        return R.ok();
    }

    /**
     * 删除角色
     * @param roleIds
     * @return
     */
    @SysLog("删除角色")
    @PostMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public R delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);
        return R.ok();
    }
}
