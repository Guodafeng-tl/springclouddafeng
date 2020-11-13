package cloud.quartzJob;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    /**newJob(DateTimeJob.class)声明业务类
     * withIdentity("DateTimeJob")给JobDetail起一个名字
     * usingJobData("msg","hello quartz")//每个JobDetail内都有一个Map，
     * 包含了关联到这个Job的数据，在Job类中可以通过context获取
     * storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
     *
     * @return
     */
    @Bean
    public JobDetail printTimeJobDetail(){
        return JobBuilder.newJob(DateTimeJob.class)
                .withIdentity("DateTimeJob")
                .usingJobData("msg","hello quartz")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger printTimeJobTrigger(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(printTimeJobDetail())
                .withIdentity("quartzTaskService")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
