package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : dafeng.guo
 * @date : 16:26 2020/12/25
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RabbitConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerMain.class, args);
    }
}
