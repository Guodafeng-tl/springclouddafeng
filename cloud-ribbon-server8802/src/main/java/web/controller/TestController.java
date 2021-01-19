package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : dafeng.guo
 * @date : 10:39 2021/1/19
 **/
@RestController
@Slf4j
public class TestController {

    @GetMapping("/testRibbon")
    public String testRibbon() {
        log.info("我是-RibbonServer8802");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(new Date());

        return "我是-RibbonServer8802"+"---"+format;
    }
}
