package web.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : dafeng.guo
 * @date : 10:15 2022/4/13
 **/
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonConfig {
    private String host;
    private int port;
    private int database;

    private static final String REDIS_PREFIX="redis://";

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress(REDIS_PREFIX + host + ":" + port).setDatabase(database);
        return (Redisson) Redisson.create(config);
    }

}
