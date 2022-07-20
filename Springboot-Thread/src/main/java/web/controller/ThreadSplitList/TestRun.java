package web.controller.ThreadSplitList;

import java.util.concurrent.TimeUnit;

/**
 * 程序中如果出现异常 默认锁会被释放
 * 多线程时异常处理要谨慎
 * 第一个线程在同步代码块抛出异常时，没有try catch 处理，
 * 其他线程会拿到释放的锁进入同步代码块有可能访问到异常数据并进行操作
 */
public class TestRun  {
    private int count = 0;


    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+"【start】");
        while (true){
            count++;
            System.out.println(Thread.currentThread().getName()+"【count"+count);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5){
                 int i=1/0;//这里异常锁被释放，要想不被释放需要try catch异常
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        TestRun testRun = new TestRun();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                testRun.m();
            }
        };
        new Thread(runnable,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(runnable,"t2").start();
    }
}
