package web.controller;

import cn.hutool.extra.tokenizer.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.OrderService;
import web.service.ServiceImpl;
import web.service.TestAbstractCommonParse;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author : dafeng.guo
 * @date : 17:25 2021/8/24
 **/
@Slf4j
@RestController
public class TestController {
    @Autowired
    ServiceImpl demoService;
    @Autowired
    OrderService orderService;
    @Autowired
    TestAbstractCommonParse testAbstractCommonParse;

    /**
     * 最大线程数
     */
    private static final int MAX_THREAD = 1000;
    /**
     * 允许一个或多个线程去等待其他线程完成
     */
    private CountDownLatch cdl = new CountDownLatch(MAX_THREAD);
    /**
     * 模拟高并发 feign调用请求,降低跨服务请求次数,提升请求效率
     */
    @RequestMapping("/testJuc")
    public Date testJuc() {
        String orderCode = "xxx";  //随便定义个字符串模拟订单号
        for (int i = 0; i < MAX_THREAD; i++) {
            new Thread(() -> {
                try {
                    cdl.await(5, TimeUnit.SECONDS);
                    //cdl.await();
                    orderService.testJuc(orderCode);
                    //log.info("子线程名称:"+Thread.currentThread().getName() +"【时间】"+ new Date());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        cdl.countDown();  //线程从1到0 的瞬间 执行 等待后的代码
        log.info("主线程名称和时间:"+Thread.currentThread().getName()+"【】"+new Date());
        return new Date();
    }

    @RequestMapping("/test")
    public void test() throws Exception {
        new Thread(()->{
            try {
                demoService.call();
            } catch (Exception e) {
                log.error("捕捉到的异常"+e.getMessage());
            }
        }).start();
    }

    @GetMapping("/commonParse")
    public void commonParse(){
        log.info("trace log TestController commonParse");
        testAbstractCommonParse.doHandleAbstract();
    }
}
