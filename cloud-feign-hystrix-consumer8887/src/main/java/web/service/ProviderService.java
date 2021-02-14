package web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : dafeng.guo
 * @date : 21:42 2021/2/14
 * fallback = ProviderServiceImpl.class指向服务降级的兜底类
 **/
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-8888",fallback = ProviderServiceImpl.class)
public interface ProviderService {

    @GetMapping("/provider/hystrix/ok/{id}")
    public String providerInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/provider/hystrix/timeout/{id}")
    public String providerInfo_TimeOut(@PathVariable("id") Integer id);
}
