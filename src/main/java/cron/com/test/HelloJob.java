package cron.com.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

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
 * @date 2017/9/28
 * @since 1.0
 */
public class HelloJob implements Job {

    public HelloJob(){}

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("do HelloJob");
        System.out.println(jobExecutionContext.getJobDetail().getJobDataMap().get("key1"));
        System.out.println(jobExecutionContext.getMergedJobDataMap().get("key1"));
    }
}
