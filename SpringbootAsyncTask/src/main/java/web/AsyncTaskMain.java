package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author : dafeng.guo
 * @date : 11:01 2020/12/31
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAsync
public class AsyncTaskMain {
    public static void main(String[] args) {
        SpringApplication.run(AsyncTaskMain.class,args);
    }
}
