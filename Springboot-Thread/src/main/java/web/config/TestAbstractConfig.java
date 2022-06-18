package web.config;

import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.service.*;

import java.util.Map;

/**
 * @author : dafeng.guo
 * @date : 16:13 2022/4/27
 * 多个类继承同一个抽象类
 * 可以在bean中全部获取bean实例
 **/
@Configuration
@Slf4j
public class TestAbstractConfig {

    @Bean
    public TestAbstractSecond testAbstractSecond(){
        return new TestAbstractSecond();
    }

    @Bean
    public TestAbstractThree testAbstractThree(){
        return new TestAbstractThree();
    }

    /**
     * 参数中map可以直接获取 TestAbstractService下 另外一个 TestAbstractSecond实现类实例
     * @param map
     * @return
     */
    @Bean
    public TestAbstractCommonParse testAbstractFirst(Map<String, TestAbstractService> map){
        TestAbstractCommonParse testAbstractCommonParse = new TestAbstractCommonParse();
        if (MapUtil.isNotEmpty(map)){
            System.out.println("8888888888888888");
            map.forEach((key,value)->{
                log.info("【key值:->"+key+"】【value值->:】"+value);
                testAbstractCommonParse.addTestAbstractService(value);
            });
        }
        return new TestAbstractCommonParse();
    }
}
