package s3.inter;

import com.amazonaws.services.s3.AmazonS3;
import lombok.Data;

/**
 * @author : dafeng.guo
 * @date : 15:40 2020/12/29
 **/
@Data
public class OSSServiceImpl implements OSSService {

    private String bucketName;
    private AmazonS3 s3;
}
