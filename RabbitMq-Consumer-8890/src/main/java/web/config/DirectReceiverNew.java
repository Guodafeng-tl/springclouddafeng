package web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
@Slf4j
public class DirectReceiverNew {

    @RabbitHandler
    public void process(Map testMessage) {
        log.info("DirectReceiverNew消费者收到消息  : " + testMessage.toString());
    }

}
