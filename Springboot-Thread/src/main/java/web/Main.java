package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author : dafeng.guo
 * @date : 13:53 2021/3/25
 * 啊哈
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableScheduling
//dafeng1
@EnableRetry
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
