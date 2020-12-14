package cloud.service;

import org.springframework.stereotype.Service;

/**
 * @author : dafeng.guo
 * @date : 14:36 2020/12/14
 **/
@Service
public class ProviderFeignServiceImpl implements ProviderFeignService{
    @Override
    public String feignTest() {
        return "this is Provider8888 feignTest";
    }
}
