import java.lang.annotation.*;

/**
 * @author : dafeng.guo
 * @date : 14:46 2022/3/26
 * 自定义 元注解
 **/
public class MyCustomizeAnnotation {

    @MyAnnotation(name = "dafeng",schools = {"一高","交大"})
    public void myAnnotationTest(){

    }
}


/**
 * 定义一个注解
 * @interface 声明一个注解
 */
//@Target表明注解是定义到方法、类、还是字段
@Target(value = {ElementType.METHOD})

//@Retention 表明注解在代码哪里有效  源代码 字节码 类加载器加载字节码运行间
@Retention(RetentionPolicy.RUNTIME)

//表示是否将我们的注解生成在javadoc文件中
@Documented

//@Inherited 表示子类可以继承父类注解
@Inherited
@interface  MyAnnotation{
    //注解的参数： 参数类型 + 参数名()
    String name();
    //如果有 default 值 使用该注解时 参数名可写可不写
    int id() default 0;

    String[] schools();
}
