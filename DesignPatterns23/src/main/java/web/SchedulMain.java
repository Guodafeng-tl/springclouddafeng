package web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import web.single.HungrySingleton;
import web.single.LazySingleton;
import web.single.MyThread;

/**
 * @author : dafeng.guo
 * @date : 15:38 2021/4/20
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class SchedulMain {
    public static void main(String[] args) {
        //注释掉这一行不以springboot方式启动
        //SpringApplication.run(SchedulMain.class, args);

        //以main方法直接运行

        //测试单例模式
        log.info("单例模式测试**********************************************");
        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());
        thread1.start();
        thread2.start();


    }
}
