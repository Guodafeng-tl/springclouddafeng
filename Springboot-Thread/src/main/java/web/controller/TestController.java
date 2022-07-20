package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

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
    @Autowired
    StrageContext strageContext;

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
    public Date testJuc() throws InterruptedException {
        String orderCode = "xxx";  //随便定义个字符串模拟订单号
        for (int i = 0; i < MAX_THREAD; i++) {
            new Thread(() -> {
                try {
                    cdl.countDown();
                    cdl.await();
                    //cdl.await();
                    orderService.testJuc(orderCode);
                    //log.info("子线程名称:"+Thread.currentThread().getName() +"【时间】"+ new Date());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(3000);
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

    @GetMapping("/testStrategyAbstract")
    public List<StrategyAbstract> testStrategyAbstract(){

        List<StrategyAbstract> result = new ArrayList<>();
        List<String> beanNames = Arrays.asList("FIRST", "SECOND");
        beanNames.forEach(beanName -> {
            StrategyAbstract strategyInfo = strageContext.getStrategyInfo(beanName);

            strategyInfo.printBeanName();
            result.add(strategyInfo);
        });
        return result;
    }

    /*
    正则表达式
     */
    @GetMapping("/testJrebel")
    public void jrebel(){
        System.out.println("1111");
        System.out.println("999");
        System.out.println("6666");
    }

    private static Pattern  pattern = Pattern.compile("[0-9]*");
    public static boolean isNumber(String str) {
        // 通过Matcher进行字符串匹配
        Matcher m = pattern.matcher(str);
        // 如果正则匹配通过 m.matches() 方法返回 true ，反之 false
        return m.matches();

    }

    /**
     * 校验数字  包括百分号
     * @param str
     * @return
     */
    public static boolean isNumeric2(String str) {
        Boolean isNumber = str.matches("-?[0-9]+.?[0-9]*");
        return isNumber;
    }

}