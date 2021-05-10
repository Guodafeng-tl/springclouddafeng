package web.SchedulConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : dafeng.guo
 * @date : 15:42 2021/4/20
 **/
@Component
@EnableScheduling
@Slf4j
public class SchdulTask {
    @Scheduled(cron = "0/30 * * * * ?")
    public void scheduledTask1(){
        String cron = "0 0/10 * * * ? ";
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);
        Date currentTime = new Date();
        System.out.println("currentTime: " + currentTime);
        // currentTime为计算下次时间点的开始时间
        Date nextTimePoint = cronSequenceGenerator.next(currentTime);
        System.out.println("nextTimePoint: " + nextTimePoint);
        log.info("scheduledTask1任务开始执行时间-------"+new Date().toString());
    }
}
