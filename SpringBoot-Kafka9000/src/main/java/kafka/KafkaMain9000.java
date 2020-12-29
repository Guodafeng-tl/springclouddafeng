package kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : dafeng.guo
 * @date : 11:30 2020/12/29
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KafkaMain9000 {
    public static void main(String[] args) {
        SpringApplication.run(KafkaMain9000.class,args);
    }
}
