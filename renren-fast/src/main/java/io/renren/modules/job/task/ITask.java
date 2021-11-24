package io.renren.modules.job.task;

/**
 * 定时任务接口，所有定时任务都要实现该接口
 *
 * @author 张乃川
 * @date 2021/11/24 14:18
 */
public interface ITask {
    
    /**
     * 执行定时任务接口 
     * @author 张乃川
     * @date 2021/11/24 14:18
     * @param params 参数，多参数使用JSON格式
     */
    void run(String params);
}
