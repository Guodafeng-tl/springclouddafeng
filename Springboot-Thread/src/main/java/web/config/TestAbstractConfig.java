package web.config;

import cn.hutool.core.map.MapUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.service.TestAbstractFirst;
import web.service.TestAbstractSecond;
import web.service.TestAbstractService;

import java.util.Map;

/**
 * @author : dafeng.guo
 * @date : 16:13 2022/4/27
 * 多个类继承同一个抽象类
 * 可以在bean中全部获取bean实例
 **/
@Configuration
public class TestAbstractConfig {

    @Bean
    public TestAbstractSecond testAbstractSecond(){
        return new TestAbstractSecond();
    }

    /**
     * 参数中map可以直接获取 TestAbstractService下 另外一个 TestAbstractSecond实现类实例
     * @param map
     * @return
     */
    @Bean
    public TestAbstractFirst testAbstractFirst(Map<String, TestAbstractService> map){
        if (MapUtil.isNotEmpty(map)){
            System.out.println(0);
        }
        return new TestAbstractFirst();
    }
}
