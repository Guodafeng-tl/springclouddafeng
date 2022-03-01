package web.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.TestTransactionalService;

import java.util.Map;
import java.util.Objects;
@RestController
@Slf4j
public class TestEqualsController {

    @Autowired
    TestTransactionalService testTransactionalService;
    @RequestMapping("/testEquals")
    public void testEquals(){
        log.info("*************************Objects.equals方法值对比****************");
        log.info("第一个参数为null, 第二个参数为abc"+";执行结果为"+Objects.equals(null,"abc"));
        log.info("第一个参数为abc, 第二个参数为null"+";执行结果为"+Objects.equals("abc",null));
        log.info("第一个参数为null, 第二个参数为null"+";执行结果为"+Objects.equals(null,null));
        log.info("两个参数都为\"\""+";执行结果为"+Objects.equals("",""));
        log.info("*************************equals方法值对比****************");
        String a= null;
        log.info("用equals()可能出现空指针"+a.equals("abc"));
    }

    @PostMapping("/test")
    public String test(){
        testTransactionalService.update(User.builder().userId(1).userAge(20).name("aaa").build());
        return "SUCCESS";
    }
}
