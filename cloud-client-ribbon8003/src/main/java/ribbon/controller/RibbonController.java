package ribbon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ribbon.service.testFeignService;

/**
 * @author : dafeng.guo
 * @date : 11:27 2020/12/14
 **/
@RestController
@Slf4j
public class RibbonController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ribbon.service.testFeignService testFeignService;
    @GetMapping("/byRibbon")
    public String getInfo(){
        return restTemplate.getForObject("http://Ribbon-Server/testRibbon",String.class);
    }

    @GetMapping("/consumerTestFeign")
    public String testInfo(){
        return testFeignService.testfeign();
    }
}
