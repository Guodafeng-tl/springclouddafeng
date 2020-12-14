package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudServer8888 {
    public static void main(String[] args) {
        SpringApplication.run(CloudServer8888.class,args);
    }
}
