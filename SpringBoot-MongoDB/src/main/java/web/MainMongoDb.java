package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : dafeng.guo
 * @date : 10:32 2021/1/5
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MainMongoDb {
    public static void main(String[] args) {
        SpringApplication.run(MainMongoDb.class,args);
    }
}
