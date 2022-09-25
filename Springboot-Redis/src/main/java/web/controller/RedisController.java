package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.entity.Student;
import web.service.TestService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author : dafeng.guo
 * @date : 22:40 2021/3/6
 **/
@RestController
@Slf4j
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private Redisson redisson;
    @Resource
    private TestService testService;


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

    /**
     * 右边放入list集合
     * @return
     */
    @GetMapping("/testList")
    public String testList(){
        redisTemplate.opsForList().rightPush("list","a");
        redisTemplate.opsForList().rightPush("list","b");
        redisTemplate.opsForList().rightPush("list","c");
        return "testList SUCCESS";
    }

    /**
     * 右边放入list集合
     * @return
     */
    @GetMapping("/getList")
    public String getList(){
        redisTemplate.opsForList().leftPop("list");
        return "getList SUCCESS";
    }

    @GetMapping("/testRedisson")
    public void redisson(){
        String lockKey = "REDISSION:20220413-df-test";
        //公平锁
        RLock fairLock = redisson.getFairLock(lockKey);
        Boolean releaseLock = false;
        try {
            boolean b = fairLock.tryLock(1, 120, TimeUnit.SECONDS);
            if (b) {
                releaseLock = b;
                log.info("66666666666666666俺拿到锁了:{}"+Thread.currentThread().getName());
                //睡60秒 测试加锁效果
                Thread.sleep(60000);
            }else {
                log.error("88888888888888获取锁失败:{}"+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (releaseLock) {
                fairLock.unlock();
            }
        }

    }


    @GetMapping("/testRedisCache")
    public List<Map<String, Object>>  cacheTest(){
        List<Map<String, Object>> result = testService.queryById(1L);
        testService.queryById2(2L);
        return result;
    }

    @GetMapping("/getFromCache")
    public Object  getFromCache(){
        Object result1 = redisTemplate.opsForValue().get("20220925-df::2");
        return result1;
    }

}
