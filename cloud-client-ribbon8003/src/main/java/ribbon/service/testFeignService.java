package ribbon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : dafeng.guo
 * @date : 14:41 2020/12/14
 **/
@Component
@FeignClient(value = "cloud-provide8888-service")
public interface testFeignService {

    @GetMapping("/testfeign")
    String testfeign();
}
