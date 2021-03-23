package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : dafeng.guo
 * @date : 15:57 2021/3/19
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ShiroMain {
    public static void main(String[] args) {
        SpringApplication.run(ShiroMain.class,args);
    }
}
