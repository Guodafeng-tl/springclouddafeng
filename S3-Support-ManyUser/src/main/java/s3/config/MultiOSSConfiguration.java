package s3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import s3.OSSServiceMap;
import s3.dict.Constants;

/**
 * @author : dafeng.guo
 * @date : 16:35 2020/12/29
 **/
@Configuration
@ConditionalOnProperty(name = Constants.OSS,havingValue = "true")
public class MultiOSSConfiguration {

    @Bean(name="ossSeriveMap")
    @Description("对象存储连接放入Map集合")
    public OSSServiceMap ossServiceMap(@Autowired MultiOSSProperties multiOSSProperties){
        OSSServiceMap ossServiceMap = new OSSServiceMap();
        ossServiceMap.init(multiOSSProperties);
        return ossServiceMap;
    }
}
