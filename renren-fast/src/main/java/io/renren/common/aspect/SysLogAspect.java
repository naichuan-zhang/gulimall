package io.renren.common.aspect;

import com.google.gson.Gson;
import io.renren.common.annotation.SysLog;
import io.renren.common.utils.HttpContextUtils;
import io.renren.common.utils.IPUtils;
import io.renren.common.utils.ShiroUtils;
import io.renren.modules.sys.entity.SysLogEntity;
import io.renren.modules.sys.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Naichuan Zhang
 * @since 11/20/2021
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(io.renren.common.annotation.SysLog)")
    public void logPointcut() {
    }

    @Around("logPointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = pjp.proceed();
        // 执行时长（毫秒）
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveSysLog(pjp, time);
        return result;
    }

    private void saveSysLog(ProceedingJoinPoint pjp, long time) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        SysLogEntity sysLog = new SysLogEntity();
        SysLog syslog = method.getAnnotation(SysLog.class);
        if (syslog != null) {
            // 注解上的描述
            sysLog.setOperation(syslog.value());
        }
        // 请求的方法名
        String className = pjp.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的参数
        Object[] args = pjp.getArgs();
        try {
            String params = new Gson().toJson(args);
            sysLog.setParams(params);
        } catch (Exception ignored) {
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        sysLog.setIp(IPUtils.getIpAddr(request));
        // 用户名
        String username = ShiroUtils.getUserEntity().getUsername();
        sysLog.setUsername(username);
        sysLog.setTime(time);
        sysLog.setCreateDate(new Date());
        // 保存系统日志
        sysLogService.save(sysLog);
    }
}
