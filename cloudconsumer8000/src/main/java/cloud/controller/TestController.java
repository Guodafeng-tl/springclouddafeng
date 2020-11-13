package cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 过滤器和拦截器测试
 */
@Slf4j
@RestController
public class TestController {


    @GetMapping("/getInfo")
    public String getInfo(){
        return "this is getInfo";
    }

    @GetMapping("/login")
    public String login(){
        return "this is login";
    }

    @GetMapping("/toLogin")
    public String toLogin(){
        return "this is toLogin";
    }

    @GetMapping("/testFilter")
    public String testFilter(){
        return "this is testFilter";
    }
    @GetMapping("/testfilter1")
    public String testfilter1(){
        return "this is testfilter1111111111111111";
    }

    @GetMapping("/testfilter2")
    public String testfilter2(){
        return "this is testfilter22222222222222222";
    }

    @GetMapping("/hello")
    public String hello(){
        return "this is hello9999999999999999";
    }

    @GetMapping("/failed")
    public String failed(){
        return "this is failed8888888888888";
    }

    @GetMapping("/test1")
    public String test1(){
        return "this is test11111111111111";
    }
    @GetMapping("/test2")
    public String test2(){
        return "this is test222222222222";
    }
    @GetMapping("/hellotest")
    public String hellotest(){
        return "this is hellotest6666666666";
    }
}
