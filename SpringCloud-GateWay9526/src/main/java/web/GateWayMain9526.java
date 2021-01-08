package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : dafeng.guo
 * @date : 13:29 2021/1/8
 **/
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9526 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9526.class,args);
    }
}
