package web.service.Impl;

import org.springframework.stereotype.Service;
import web.service.OpenFeignService;

/**
 * @author : dafeng.guo
 * @date : 16:26 2021/2/14
 **/
@Service
public class OpenFeignServiceImpl implements OpenFeignService {

    @Override
    public String sayHello() {
        return "sayHello,I am cloud-provide8801~~~~~~~~";
    }
}
