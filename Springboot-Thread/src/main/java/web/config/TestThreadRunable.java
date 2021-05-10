package web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : dafeng.guo
 * @date : 13:55 2021/3/25
 **/
//@Configuration
@Slf4j
public class TestThreadRunable implements Runnable{

    @Override
    @Scheduled(cron="0/5 * * * * ?")
    public void run() {
        for (int i = 0; i < 10; i++) {
            log.info(Thread.currentThread().getName() + ":" + i);
        }
    }

     @Bean
    public void startThread() {
        //创建线程对象，把实现了Runnable接口的对象作为参数传入；
        Thread thread1 = new Thread(new TestThreadRunable());
        thread1.setName("aaaa");
        thread1.start();//启动线程；
        Thread thread2 = new Thread(new TestThreadRunable());
        thread2.setName("bbbbb");
        thread2.start();
    }

    /**
     * 每五秒执行一次
     */
    /*@Scheduled(cron="0/5 * * * * ?")
    public void startThread(){
        Thread thread1 = new Thread(new TestThreadRunable());
        thread1.setName("aaaa");
        thread1.start();//启动线程；
    }*/
    @Bean
    public void testCronSequenceGenerator() throws Exception{
        String cron = "1/5 * * * * ? ";
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d1 = df.parse("2021-03-25 10:00:08");
        System.out.println("currentTime: " + d1);
        Date d2 = cronSequenceGenerator.next(d1);

        Date currentTime = new Date();

        System.out.println("currentTime: " + currentTime);

        Date nextTimePoint = cronSequenceGenerator.next(currentTime);
        System.out.println("nextTimePoint: " + nextTimePoint);

        Date nextNextTimePoint = cronSequenceGenerator.next(nextTimePoint);

        System.out.println("nextNextTimePoint: " + nextNextTimePoint);
    }

}
