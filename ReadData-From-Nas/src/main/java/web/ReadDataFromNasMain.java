package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author : dafeng.guo
 * @date : 16:53 2020/12/17
 * exclude = {DataSourceAutoConfiguration.class}
 * 因为添加了数据库组件，所以autoconfig会去读取数据源配置，
 * 而新建的项目还没有配置数据源/URL地址错误，所以会导致异常出现。
 * 排除此类的autoconfig
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class ReadDataFromNasMain {
    public static void main(String[] args) {
        SpringApplication.run(ReadDataFromNasMain.class,args);
    }
}
