package web.controller;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class ObjectTest {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println("对象内部信息");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println("对象占用内存大小");
        System.out.println(GraphLayout.parseInstance(obj).totalSize());
    }
}
