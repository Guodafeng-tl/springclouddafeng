package web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.Resource;

/**
 * @author : dafeng.guo
 * @date : 16:14 2021/3/19
 **/
@Configuration
@Slf4j
public class FilterConfig {
    @Resource
    MyFiletr myFiletr;
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        log.info("FilterRegistrationBean过滤配置方法执行***********************************");
        FilterRegistrationBean registration = new FilterRegistrationBean(myFiletr);
        registration.addUrlPatterns("/*");
        registration.setName("myFilter");
        return registration;
    }
}
