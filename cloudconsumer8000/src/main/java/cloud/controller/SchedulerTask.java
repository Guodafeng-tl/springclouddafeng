package cloud.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {

    private int count = 0;

    /**
     * @Author Smith
     * @Description 设置没6秒执行一次
     * @Date 14:23 2019/1/24
     * @Param
     * @return void
     **/
    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("dafeng this is scheduler task running " + (count++));
    }

}
