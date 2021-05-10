package web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.Date;

import static java.util.concurrent.Executors.*;

/**
 * @author : dafeng.guo
 * @date : 15:43 2021/3/26
 **/
//@Configuration
@Slf4j
public class ScheduledTest implements SchedulingConfigurer {


    /**
     * 同步执行     Scheduled
     * @throws InterruptedException
     */
    @Scheduled(cron = "0/1 * * * * ?")
    public void synTest1() throws InterruptedException {
        log.info("this ia synTest11111111111111111()   *****************************time:" + new Date().toString());
        //模拟长时间执行，比如IO操作，http请求
        Thread.sleep(5000);
    }


    @Scheduled(cron = "0/1 * * * * ?")
    public void synTest2() throws InterruptedException {
        log.info("this ia synTest222222222222222222222()   *****************************time:" + new Date().toString());
    }

    /**
     * 任务调度默认是单线程会阻塞    设置多个线程池
     * @param taskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //taskRegistrar.setScheduler(newScheduledThreadPool(5));
    }
}
