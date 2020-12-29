package kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author : dafeng.guo
 * @date : 13:57 2020/12/29
 **/
@Component
@Slf4j
public class Consumer {

    @KafkaListener(topics = "demo")
    public void listen(ConsumerRecord< ? , ? > record){
        log.info(record.topic()+" "+record.value());
    }
}
