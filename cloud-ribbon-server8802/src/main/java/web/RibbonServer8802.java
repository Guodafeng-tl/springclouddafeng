package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : dafeng.guo
 * @date : 10:38 2021/1/19
 **/
@SpringBootApplication
@EnableEurekaClient
public class RibbonServer8802 {
    public static void main(String[] args) {
        SpringApplication.run(RibbonServer8802.class,args);
    }
}
