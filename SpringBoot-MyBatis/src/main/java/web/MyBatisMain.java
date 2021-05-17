package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : dafeng.guo
 * @date : 9:41 2021/5/17
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyBatisMain {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisMain.class, args);
    }
}
