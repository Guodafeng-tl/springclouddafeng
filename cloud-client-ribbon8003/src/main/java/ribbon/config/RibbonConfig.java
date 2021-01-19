package ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import lombok.extern.slf4j.Slf4j;
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
    @Bean
    @LoadBalanced
    public RestTemplate ribbonRule(){
        return new RestTemplate();
    }

    // 配置随机策略
    /*@Bean
    public IRule ribbonRandomRule() {
        return new RandomRule();
    }*/

}
