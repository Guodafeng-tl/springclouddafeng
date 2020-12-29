package kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : dafeng.guo
 * @date : 13:55 2020/12/29
 **/
@RestController
public class ProductController {

    @Resource
    KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/sendMsg")
    public String send(String message){
        kafkaTemplate.send("demo",message);
        return "SUCESS";
    }

}
