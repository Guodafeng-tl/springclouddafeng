package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : dafeng.guo
 * @date : 22:40 2021/3/6
 **/
@RestController
@Slf4j
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/testRestTemplateAddStr")
    public String testRestTemplateAdd(){
        redisTemplate.opsForValue().set("name","dafeng");
        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("111","aaa");
        hashMap.put("222","bbb");
        hashMap.put("333","ccc");
        redisTemplate.opsForHash().putAll("hashMap",hashMap);
        redisTemplate.opsForList().leftPush("list","a");
        redisTemplate.opsForList().leftPush("list","b");
        redisTemplate.opsForList().leftPush("list","c");
        return "testRestTemplateAddStr SUCCESS";
    }

    @GetMapping("/testRestTemplateGetStr")
    public String testRestTemplateGetStr(){
        Object value2 = redisTemplate.opsForValue().get("name");
        log.info("name对应的value值"+value2);
        List<Object> hashMap = redisTemplate.opsForHash().values("hashMap");
        log.info("hashMap",hashMap);
        String student0 = (String) redisTemplate.opsForList().index("list", 0);
        log.info(student0.toString());
        String student1 =(String) redisTemplate.opsForList().index("list", 1);
        log.info(student1.toString());
        return "testRestTemplateGetStr SUCCESS";
    }

}
