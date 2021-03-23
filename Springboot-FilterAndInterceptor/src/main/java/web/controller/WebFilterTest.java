package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : dafeng.guo
 * @date : 16:12 2021/3/19
 **/
@RestController
@Slf4j
public class WebFilterTest {

    @GetMapping("/dafeng")
    public void dafeng(){
        log.info("this is dafeng test~~~");
    }
    @GetMapping("/test")
    public void test(){
        log.info("this is test test~~~");
    }
    @GetMapping("/testFilter")
    public void testFiletr(){
        log.info("this is testFiletr test~~~");
    }
}
