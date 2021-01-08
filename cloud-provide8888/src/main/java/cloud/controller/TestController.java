package cloud.controller;

import cloud.service.ProviderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private ProviderFeignService providerFeignService;

    @GetMapping("/testRibbon")
    public String testRibbon(){
        return "this server8888";
    }

    @GetMapping("/testfeign")
    public String testfeign(){
        return providerFeignService.feignTest();
    }

    @GetMapping(value = "/test/getInfo/666")
    public String testInfo(){
        return "8888这是来自getInfo的请求~~~~";
    }

    @GetMapping(value = "/test/getMessage/888")
    public String getMessage(){
       return "8888这是来自getMessage的请求~~~~";
    }
}
