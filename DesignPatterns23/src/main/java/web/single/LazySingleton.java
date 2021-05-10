package web.single;

import lombok.Synchronized;

/**
 * @author : dafeng.guo
 * @date : 9:47 2021/4/21
 * 单例模式之懒汉模式，线程不安全
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率
 **/
public class LazySingleton {

    private static LazySingleton instance;
    private LazySingleton() {

    }

    //不加锁 线程不安全
    public static LazySingleton getInstance() {
        if (instance == null){
            return new LazySingleton();
        }
        return instance;
    }

    //加锁 影响效率
    public static synchronized  LazySingleton getInstance1() {
        if (instance == null){
            return new LazySingleton();
        }
        return instance;
    }
}
