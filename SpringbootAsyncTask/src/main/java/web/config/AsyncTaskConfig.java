package web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author : dafeng.guo
 * @date : 11:03 2020/12/31
 **/
@Component
@Slf4j
public class AsyncTaskConfig {

    @Async
    public void task1() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        log.info("task1任务耗时完成时间"+(end-start)+"毫秒");
    }

    public void task11() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        log.info("task11任务耗时完成时间"+(end-start)+"毫秒");
    }

    public void task2() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        log.info("task2任务耗时完成时间"+(end-start)+"毫秒");
    }

    public void task3() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        log.info("task3任务耗时完成时间"+(end-start)+"毫秒");
    }
}
