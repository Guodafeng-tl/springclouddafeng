package s3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : dafeng.guo
 * @date : 15:23 2020/12/29
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class S3Main8333 {
    public static void main(String[] args) {
        SpringApplication.run(S3Main8333.class,args);
    }
}
