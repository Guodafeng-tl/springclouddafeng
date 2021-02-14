package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.OpenFeignService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author : dafeng.guo
 * @date : 10:39 2021/1/19
 **/
@RestController
@Slf4j
public class TestController {

    @Resource
    private OpenFeignService openFeignService;
    @GetMapping("/testRibbon")
    public String testRibbon() {
        log.info("我是-RibbonServer8801");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(new Date());

        return "我是-RibbonServer8801"+"---"+format;
    }

    @GetMapping("/testOpenFign")
    public String testOpenFign(){
        return openFeignService.sayHello();
    }

    @GetMapping("/openFeign/timeOut")
    public String openFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "***hello,I am cloud-provide8801*******";
    }

}
