package cron.com.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

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
public class QuarzaTest {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        System.out.println("分割线=--=");

        // 定时任务执行内容
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("jobname", "jobgroup")
                .usingJobData("key1","value1")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        // 定时任务时间控制
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .usingJobData("key1","value1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(3)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);

        scheduler.getListenerManager().addJobListener(new MyJobListener(), KeyMatcher.keyEquals(new JobKey("jobname","jobgroup")));

        System.out.println("分割线=--=");
        Thread.sleep(10000L);
        System.out.println("pause=--=");
        scheduler.pauseAll();
        scheduler.resumeAll();
        scheduler.shutdown();
    }



}
