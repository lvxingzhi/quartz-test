package cron.com.test;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/10/9
 * @since 1.0
 */
public class MyJobListener implements JobListener{
    @Override
    public String getName() {
        return "myJobListener";
    }

    /**
     * job 执行前
     * @param context
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("任务执行前");
    }

    /**
     * trigger 执行异常
     * @param context
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("任务Trigger执行异常");
    }

    /**
     * job 执行后
     * @param context
     */
    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("任务执行后");
    }
}
