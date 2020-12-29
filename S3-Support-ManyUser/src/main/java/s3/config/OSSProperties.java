package s3.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import s3.dict.Constants;

/**
 * @author : dafeng.guo
 * @date : 15:25 2020/12/29
 **/
@Component
@ConfigurationProperties(prefix = "many.oss")
@ConditionalOnProperty(name = Constants.OSS,havingValue = "false",matchIfMissing = true)
public class OSSProperties {
    /**
     * 对象存储访问地址
     */
    private String endPoint;
    /**
     * 对象存储key值，类似用户名
     */
    private String accessKey;
    /**
     * 对象存储密钥
     */
    private String secretKey;

    /**
     * 对象存储桶
     */
    private String bucketName;
    /**
     * 对象存储最大连接数
     */
    private String maxConnections;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(String maxConnections) {
        this.maxConnections = maxConnections;
    }
}
