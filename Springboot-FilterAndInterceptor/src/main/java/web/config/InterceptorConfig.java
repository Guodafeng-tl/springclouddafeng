package web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : dafeng.guo
 * @date : 16:42 2021/3/19
 **/
@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    MyHanderInterceptor myHandlerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始执行拦截配置方法addInterceptors **************");
        //添加拦截路径
        List<String> list=new ArrayList<>();
        list.add("/*");
        List<String> list2=new ArrayList<>();
        list2.add("/dafeng");
        list2.add("/wwwww");
        registry.addInterceptor(myHandlerInterceptor)
                .addPathPatterns(list)//指定黑名单，只要匹配到路径就运行拦截器的方法
                .excludePathPatterns(list2);//指定白名单，直接绕过拦截器
    }
}
