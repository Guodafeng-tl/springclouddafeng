package web.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author : dafeng.guo
 * @date : 15:37 2021/3/13
 **/
@PersistJobDataAfterExecution   //jobDataMap持久化
@DisallowConcurrentExecution    //防止并发执行(一个任务执行完之后再执行下一个)
@Slf4j
public class QuartzJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            Thread.sleep(6000);
            log.info("调度器实例id："+context.getScheduler().getSchedulerInstanceId());
            log.info("任务名taskName:"+context.getJobDetail().getKey().getName());
            Date dt =new Date();
            DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            log.info("执行时间："+dFormat.format(dt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
