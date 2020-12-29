package s3.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import s3.dict.Constants;
import s3.inter.OSSService;
import s3.inter.OSSServiceImpl;

/**
 * @author : dafeng.guo
 * @date : 15:34 2020/12/29
 **/
//@Configuration  测试根据情况开放
@ConditionalOnProperty(name = Constants.OSS,havingValue = "false",matchIfMissing = true)
public class OSSConfiguration {

    @Bean(name = "ossService")
    @Description(("对象存储连接实例"))
    public OSSService OSSService(@Autowired OSSProperties ossProperties){
        String endPoint = ossProperties.getEndPoint();
        String accessKey = ossProperties.getAccessKey();
        String secretKey = ossProperties.getSecretKey();
        String bucketName = ossProperties.getBucketName();
        String maxConnections = ossProperties.getMaxConnections();
        /**
         * 创建 AmasonS3对象
         */
        AwsClientBuilder.EndpointConfiguration endpointConfig =
                new AwsClientBuilder.EndpointConfiguration(endPoint, Region.getRegion(Regions.US_EAST_1).getName());

        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTPS);
        clientConfig.setMaxConnections(Integer.parseInt(maxConnections));
        AmazonS3 s3client = AmazonS3Client.builder()
                .withEndpointConfiguration(endpointConfig)
                .withClientConfiguration(clientConfig)
                .withCredentials(awsCredentialsProvider)
                .disableChunkedEncoding()
                .withPathStyleAccessEnabled(true)
                .withForceGlobalBucketAccessEnabled(true)
                .build();

        OSSServiceImpl ossService = new OSSServiceImpl();
        ossService.setBucketName(bucketName);
        ossService.setS3(s3client);
        return ossService;
    }
}
