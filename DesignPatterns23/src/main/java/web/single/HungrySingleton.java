package web.single;

/**
 * @author : dafeng.guo
 * @date : 14:17 2021/4/21
 * 饿汉模式 线程
 * 描述：这种方式比较常用，但容易产生垃圾对象。
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 **/
public class HungrySingleton {
    private static HungrySingleton instance=new HungrySingleton();
    private HungrySingleton() {

    }
    public static HungrySingleton getInstance() {
        return instance;
    }
}
