package web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author : dafeng.guo
 * @date : 17:29 2021/8/24
 **/
@Service
@Slf4j
public class ServiceImpl implements DemoService {
    private static final int i=0;
    @Retryable(value= {Exception.class},maxAttempts = 3)
    @Override
    public void call() throws Exception {
        System.out.println("i值"+i);
        System.out.println("I AM CALL...");
        test(i);
    }

    public void test(int i) throws InterruptedException {
        System.out.println("I AM TEST");
        testB();
    }
    public void testB() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("I AM TESTB");
        int a=1/0;
    }
    /*@Recover
    public void recover(RemoteAccessException e) {
        System.out.println(e.getMessage());
    }*/
}
