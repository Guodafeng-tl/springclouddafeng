package ribbon.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : dafeng.guo
 * @date : 11:23 2020/12/14
 **/
@Configuration
@Slf4j
public class RibbonConfig {
    @Value("${info}")
    private String info;

    @Bean
    @LoadBalanced
    public RestTemplate ribbonRule(){
        log.info(info);
        return new RestTemplate();
    }
}
