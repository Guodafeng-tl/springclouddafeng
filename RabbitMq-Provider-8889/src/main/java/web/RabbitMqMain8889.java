package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : dafeng.guo
 * @date : 15:18 2020/12/25
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RabbitMqMain8889 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqMain8889.class, args);
    }
}
