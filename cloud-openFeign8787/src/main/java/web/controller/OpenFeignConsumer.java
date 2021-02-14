package web.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.OpenFeignService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : dafeng.guo
 * @date : 16:21 2021/2/14
 **/
@RestController
@Slf4j
public class OpenFeignConsumer {

    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/testOpenFign")
    public String testOpenFeign(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(new Date());
        log.info(format+"***"+"我是-testOpenFign8787"+"***");
        return openFeignService.sayHello();
    }

    @GetMapping(value = "/consumer/feign/timeout")
    public String paymentFeignTimeout()
    {
        // OpenFeign客户端一般默认等待1秒钟
        return openFeignService.openFeignTimeOut();
    }
}
