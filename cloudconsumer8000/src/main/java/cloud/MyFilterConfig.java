package cloud;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class MyFilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
        /*ArrayList<String> list = new ArrayList<>();
        list.add("/login"); //只有请求的/login或hello时才会去MyFilter类
        list.add("/hello");
        filterRegistrationBean.setUrlPatterns(list);*/

        //任何请求都会去MyFilter类的doFilter方法
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
