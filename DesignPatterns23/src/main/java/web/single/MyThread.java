package web.single;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : dafeng.guo
 * @date : 14:34 2021/4/21
 **/
@Slf4j
public class MyThread implements Runnable {

    @Override
    public void run() {
        log.info("懒汉模式双重检测测试**********************************************");
        LazySingletonDoubleCheck instance = LazySingletonDoubleCheck.getInstance();
        log.info(Thread.currentThread().getName()+"；"+instance.toString());

        log.info("懒汉模式测试**********************************************");
        LazySingleton lazySingleton = LazySingleton.getInstance();
        log.info(Thread.currentThread().getName()+"；"+lazySingleton.toString());

        log.info("饿汉模式测试**********************************************");
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        log.info(Thread.currentThread().getName()+"；"+hungrySingleton.toString());
    }
}
