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
}
