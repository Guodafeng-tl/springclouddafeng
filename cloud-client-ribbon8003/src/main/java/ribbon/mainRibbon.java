package ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : dafeng.guo
 * @date : 11:22 2020/12/14
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class mainRibbon {
    public static void main(String[] args) {
        SpringApplication.run(mainRibbon.class,args);
    }
}
