package web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : dafeng.guo
 * @date : 16:23 2021/2/14
 **/
@Component
@FeignClient(value = "Ribbon-Server")
public interface OpenFeignService {

    @GetMapping("/testOpenFign")
    public String sayHello();

    @GetMapping("/openFeign/timeOut")
    public String openFeignTimeOut();
}
