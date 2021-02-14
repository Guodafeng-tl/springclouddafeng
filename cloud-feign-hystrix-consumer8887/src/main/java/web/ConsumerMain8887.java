package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : dafeng.guo
 * @date : 21:38 2021/2/14
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerMain8887 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain8887.class, args);
    }
}
