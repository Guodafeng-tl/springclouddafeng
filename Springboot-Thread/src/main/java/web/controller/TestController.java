package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.ServiceImpl;

/**
 * @author : dafeng.guo
 * @date : 17:25 2021/8/24
 **/
@Slf4j
@RestController
public class TestController {
    @Autowired
    ServiceImpl demoService;

    @RequestMapping("/test")
    public void test() throws Exception {
        new Thread(()->{
            try {
                demoService.call();
            } catch (Exception e) {
                log.error("捕捉到的异常"+e.getMessage());
            }
        }).start();
    }

}
