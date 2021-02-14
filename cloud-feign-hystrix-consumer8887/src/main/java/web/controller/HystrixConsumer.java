package web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import web.service.ProviderService;

import javax.annotation.Resource;

/**
 * @author : dafeng.guo
 * @date : 21:40 2021/2/14
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_FallbackMethod")
public class HystrixConsumer {

    @Resource
    private ProviderService providerService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String providerInfo_OK(@PathVariable("id") Integer id)
    {
        String result = providerService.providerInfo_OK(id);
        log.info("*****result: "+result);
        return result;
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "timeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    })*/
    @HystrixCommand
    public String providerInfo_TimeOut(@PathVariable("id") Integer id)
    {
        //int age = 10/0;  异常也会直接进行服务降级 执行兜底方法
        String result = providerService.providerInfo_TimeOut(id);
        log.info("*****result: "+result);
        return result;
    }

    public String timeOutFallbackMethod(@PathVariable("id") Integer id)
    {
        return "我是hystrix客户端8887,对方服务端8888系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    /**
     * 下面是全局fallback方法
     * @return
     */
    public String global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
