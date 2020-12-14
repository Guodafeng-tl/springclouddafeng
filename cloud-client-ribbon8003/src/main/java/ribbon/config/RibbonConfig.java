package ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : dafeng.guo
 * @date : 11:23 2020/12/14
 **/
@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced
    public RestTemplate ribbonRule(){
        return new RestTemplate();
    }
}
