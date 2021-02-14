package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : dafeng.guo
 * @date : 16:17 2021/2/14
 **/
@SpringBootApplication
@EnableFeignClients
public class OpenFeign8787 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeign8787.class,args);
    }
}
