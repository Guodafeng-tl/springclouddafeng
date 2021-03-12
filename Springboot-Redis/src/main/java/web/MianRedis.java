package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : dafeng.guo
 * @date : 22:37 2021/3/6
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MianRedis {
    public static void main(String[] args) {
        SpringApplication.run(MianRedis.class, args);
    }
}
