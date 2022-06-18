package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author : dafeng.guo
 * @date : 11:47 2022/5/23
 **/

@RestController
@Slf4j
public class CompletableFutureTestController {

    @GetMapping("/testComplete")
    public void testComplete() throws InterruptedException, ExecutionException {
        log.info("testComplete同步任务耗时开始执行");
        long n1 = System.currentTimeMillis();
        sleep1();
        sleep2();
        long n2 = System.currentTimeMillis();
        log.info("testComplete同步任务耗时完成时间"+(n2-n1)+"毫秒");
        log.info("testComplete使用CompletableFuture开始执行");
        long cfb = System.currentTimeMillis();
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            try {
                sleep1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> {
            try {
                sleep2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        f1.get();
        f2.get();
        f1.join();
        CompletableFuture.allOf(f1,f2).get();
        CompletableFuture.allOf(f1,f2).join();
        log.info("testComplete使用CompletableFuture耗时"+(System.currentTimeMillis()-cfb)+"毫秒");

    }

    void sleep1() throws InterruptedException {
        Thread.sleep(5000);
        log.info("trace log sleep1 5000****************");
    }
    void sleep2() throws InterruptedException {
        Thread.sleep(7000);
        log.info("trace log sleep2 7000***************");
    }
}
