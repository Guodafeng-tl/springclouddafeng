package s3;

import s3.config.MultiOSSProperties;
import s3.config.OSSProperties;
import s3.inter.OSSService;
import s3.inter.OSSServiceImpl;
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
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : dafeng.guo
 * @date : 16:39 2020/12/29
 **/
public class OSSServiceMap {

    public static  final ConcurrentHashMap<String, OSSService> serviceMap=new ConcurrentHashMap<>();

    /**
     * 通过 accessKey 匹配OSSService
     * @param accessKey
     * @return
     */
    public static OSSService get(String accessKey){
        return serviceMap.get(accessKey);
    }

    /**
     * 初始化用户名和OSSService的映射
     * @param multiOSSProperties
     */
    public void init(MultiOSSProperties multiOSSProperties){
        List<OSSProperties> ossInfos = multiOSSProperties.getOss();
        for (OSSProperties oss : ossInfos){
            add(oss);
        }
    }

    /**
     * 将多用户放入集合
     * @param ossProperties
     */

    public static void add(OSSProperties ossProperties){
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
        serviceMap.put(accessKey,ossService);

    }
}
