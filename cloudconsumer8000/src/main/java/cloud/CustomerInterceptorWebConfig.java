package cloud;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/*
拦截前的配置类
 */
@Configuration
public class CustomerInterceptorWebConfig implements WebMvcConfigurer {
    @Resource
    CustomerInterceptor customerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 自定义拦截器，添加拦截路径和排除拦截路径
        // registry.addInterceptor(customerInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/loginIn");
        //添加拦截路径
        List<String> list=new ArrayList<>();
        list.add("/getInfo");
        List<String> list2=new ArrayList<>();
        list2.add("/toLogin");
        list2.add("/testfilter1");
        registry.addInterceptor(new CustomerInterceptor())
                .addPathPatterns(list)//指定黑名单，只要匹配到路径就运行拦截器的方法
                .excludePathPatterns(list2);//指定白名单，直接绕过拦截器
    }
}
