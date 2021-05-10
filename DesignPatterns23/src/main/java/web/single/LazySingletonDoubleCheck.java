package web.single;

import lombok.Synchronized;

/**
 * @author : dafeng.guo
 * @date : 14:23 2021/4/21
 * 懒汉模式-双重检查
 **/
public class LazySingletonDoubleCheck {
    private static LazySingletonDoubleCheck instance;

    private LazySingletonDoubleCheck() {

    }

    public static LazySingletonDoubleCheck getInstance() {
        if (instance == null){
            synchronized (LazySingletonDoubleCheck.class){
                if (instance == null){
                    instance = new LazySingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
