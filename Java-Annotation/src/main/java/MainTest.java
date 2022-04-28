import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author : dafeng.guo
 * @date : 16:12 2022/3/26
 **/
public class MainTest {

    @lombok.SneakyThrows
    public static void main(String[] args) {
        Class<?> clazz = Class.forName("InitDemo");
        Method[] methods = clazz.getMethods();
        if (Objects.nonNull(methods)){
            for (Method method : methods) {
                boolean annotationFlag = method.isAnnotationPresent(AnnotatonTest.class);
                if (annotationFlag){
                    //构造对象执行该注解方法
                    method.invoke(clazz.getConstructor().newInstance(null),null);
                }
            }
        }
    }
}
