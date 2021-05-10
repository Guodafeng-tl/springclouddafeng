package web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.Date;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newScheduledThreadPool;

/**
 * @author : dafeng.guo
 * @date : 15:58 2021/3/26
 **/
@Slf4j
@Configuration
@EnableAsync
public class ScheduledAsyncTest implements SchedulingConfigurer {
    /**
     * 异步执行
     * @throws InterruptedException
     */
    @Async  //加上会调用虚拟机的线程
    @Scheduled(cron = "0/1 * * * * ?")
    public void synTest1() throws InterruptedException {
        log.info("this ia ScheduledAsyncTest 11111111111111111()   *****************************time:" + new Date().toString());
        //模拟长时间执行，比如IO操作，http请求
        Thread.sleep(5000);
        log.info("11111111111111111111111111111111111111111111()   *****************************"+Thread.currentThread().getName());
    }

    //@Async  加上会调用虚拟机的线程
    @Scheduled(cron = "0/1 * * * * ?")
    public void synTest2() throws InterruptedException {
        log.info("this ia ScheduledAsyncTest 222222222222222222222()   *****************************time:" + new Date().toString());
        log.info("2222222222222222222222222222222222222222222222()   *****************************:" + Thread.currentThread().getName());
    }

    /**
     * 任务调度默认是单线程会阻塞    设置任务调度多个线程池  并添加前缀gdf-pool-
     * @param taskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadFactory springThreadFactory = new CustomizableThreadFactory("gdf-pool-");
        taskRegistrar.setScheduler(newScheduledThreadPool(5, springThreadFactory));
    }
}
