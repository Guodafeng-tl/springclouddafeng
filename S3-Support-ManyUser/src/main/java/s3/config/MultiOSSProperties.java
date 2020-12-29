package s3.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import s3.dict.Constants;

import java.util.List;

/**
 * @author : dafeng.guo
 * @date : 16:30 2020/12/29
 **/
@Component
@ConfigurationProperties(prefix = "many")
@ConditionalOnProperty(name = Constants.OSS,havingValue = "true")
public class MultiOSSProperties {
    /**
     * 多用户
     */
    private List<OSSProperties> oss;

    public List<OSSProperties> getOss() {
        return oss;
    }

    public void setOss(List<OSSProperties> oss) {
        this.oss = oss;
    }
}
