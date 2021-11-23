package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 系统日志
 *
 * @author 张乃川
 * @date 2021/11/23 16:22
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 列表
     * @author 张乃川
     * @date 2021/11/23 16:23
     * @param
     */
    @RequiresPermissions("sys:log:list")
    @GetMapping("/list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sysLogService.queryPage(params);
        return R.ok().put("page", page);
    }
}
