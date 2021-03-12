package kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : dafeng.guo
 * @date : 13:55 2020/12/29
 **/
@RestController
@Slf4j
public class ProductController {

    @Resource
    KafkaTemplate<String,String> kafkaTemplate;

    private final String TOPIC="dafeng-kafka";

    /**
     * 同步发送
     * @param message
     * @return
     */
    @GetMapping("/sendMsg/{message}")
    @Transactional(rollbackFor = Exception.class)
    public String send(@PathVariable String message){
        kafkaTemplate.send(TOPIC,message);
        log.info("同步发送成功topic:" + TOPIC + " message:" +message);
        return "同步发送成功"+" "+message;
    }

    /**
     * 异步发送
     * @param message
     * @return
     */
    @GetMapping("/asySendMsg/{message}")
    @Transactional(rollbackFor = Exception.class)
    public String asySend(@PathVariable String message){
        kafkaTemplate.send(TOPIC, message).addCallback(success -> {
            String topic = success.getRecordMetadata().topic();
            int partition = success.getRecordMetadata().partition();
            long offset = success.getRecordMetadata().offset();
            log.info("异步发送成功："+"topic:" + topic + " partition:" + partition + " offset:" + offset);
        },failure -> {
            String failureInfo = failure.getMessage();
            log.info("异步发送失败："+failureInfo);
        });
        return "异步发送成功"+" "+message;
    }

}
