package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import web.service.ProviderService;

import javax.annotation.Resource;

/**
 * @author : dafeng.guo
 * @date : 19:32 2021/2/14
 **/
@RestController
@Slf4j
public class ProviderControlle {

    @Resource
    ProviderService providerService;

    @GetMapping("/provider/hystrix/ok/{id}")
    public String providerInfo_OK(@PathVariable("id") Integer id)
    {
        String result = providerService.providerInfo_OK(id);
        log.info("*****result: "+result);
        return result;
    }

    @GetMapping("/provider/hystrix/timeout/{id}")
    public String providerInfo_TimeOut(@PathVariable("id") Integer id)
    {
        String result = providerService.providerInfo_TimeOut(id);
        log.info("*****result: "+result);
        return result;
    }

    //====服务熔断
    @GetMapping("/provider/circuit/{id}")
    public String providerCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = providerService.providerCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }
}
