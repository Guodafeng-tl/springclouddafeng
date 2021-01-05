package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.config.AsyncTaskConfig;

/**
 * @author : dafeng.guo
 * @date : 11:15 2020/12/31
 **/
@RestController
@Slf4j
public class AsynTaskController {

    @Autowired
    AsyncTaskConfig asyncTaskConfig;

    @GetMapping("/testAsyc")
    public void testAsync() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncTaskConfig.task1();
        asyncTaskConfig.task2();
        asyncTaskConfig.task3();
        long end = System.currentTimeMillis();
        log.info("任务完成耗时"+(end-start)+"毫秒");
    }

    @GetMapping("/testAsyc1")
    public void testAsync1() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncTaskConfig.task11();
        asyncTaskConfig.task2();
        asyncTaskConfig.task3();
        long end = System.currentTimeMillis();
        log.info("任务完成耗时"+(end-start)+"毫秒");
    }

}
