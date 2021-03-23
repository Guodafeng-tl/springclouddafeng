package web.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author : dafeng.guo
 * @date : 16:09 2021/3/13
 **/
@Component
public class StartApplicationListen implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    Scheduler scheduler;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        TriggerKey triggerKey = TriggerKey.triggerKey("name1","group1");
        try {
            Trigger trigger = scheduler.getTrigger(triggerKey);
            if (trigger == null){
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey)
                        .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))  //每十秒调度一次
                        .startNow()
                        .build();

                JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                        .withIdentity("job1","group1")
                        .build();

                scheduler.scheduleJob(jobDetail, trigger);
                scheduler.start();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
